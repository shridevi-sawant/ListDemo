package com.paypal.listdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paypal.listdemo.ui.theme.ListDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListDemoTheme {
                //ListTrial()
                StudentList()
            }
        }
    }
}


@Composable
fun ListTrial(modifier: Modifier = Modifier) {

    val names = mutableListOf("John", "Merry", "Robert", "Tom")

    Column(modifier = modifier.padding(40.dp)) {
        Text(
            fontSize = 34.sp,
            modifier = Modifier.fillMaxWidth(),
            text = "PayPal Bangalore",
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(40.dp))
        LazyRow {
            items(4){
                Button(onClick = {  }) {
                    Text(text = "Category $it")
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(

            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
            modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .padding(top = 40.dp, bottom = 50.dp)
        ) {
            item {
                Text(text = "Lazy Column Demo")
            }

            items(25) {
                Text(text = "Item $it")
            }

            items(names) {
                Text(text = "Name: $it")
            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ListDemoTheme {
        ListTrial()
    }
}