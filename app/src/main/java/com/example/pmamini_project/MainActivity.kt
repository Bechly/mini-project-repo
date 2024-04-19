package com.example.pmamini_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmamini_project.data.weekDays
import com.example.pmamini_project.ui.theme.PMAMiniProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PMAMiniProjectTheme {
                val day = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
                val days by remember {
                    mutableStateOf(
                        (0..6).map {
                            weekDays(
                                title = day[it]
                            )
                        }
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 32.sp,
                        text = "Medicine Reminder"
                    )
                    LazyColumn (
                        modifier = Modifier.padding(32.dp,0.dp)
                    ){
                        items(7) { i ->
                            LayOut(days[i].title)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LayOut(days: String){
    var checkState by rememberSaveable{mutableStateOf(false)}
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier,
            fontSize = 32.sp,
            text = days
        )
        Checkbox(
            modifier = Modifier
                .padding(24.dp)
                .size(48.dp,32.dp)
                .scale(3F)
                .clickable {
                    !checkState
                },
            checked = checkState,
            onCheckedChange = {
                checkState = it
            }
        )
    }
}