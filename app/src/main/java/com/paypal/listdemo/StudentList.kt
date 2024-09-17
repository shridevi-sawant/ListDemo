package com.paypal.listdemo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Student(var name: String,
                   val rollNo: Int,
                   var marks: Int)


@Composable
fun StudentList(modifier: Modifier = Modifier) {

    //mutable collection to be used as state
    // use mutableStateListOf()
    var stdList = remember {
        mutableStateListOf<Student>().apply {
            add(Student("john", 1, 30))
        }

    }

    Surface(modifier = modifier.padding(40.dp)) {

        Column {
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {

                    val rollNo = Random.nextInt()
                    stdList.add(Student("Student $rollNo",
                        rollNo, 90))



                }) {
                Text(text = "Add New Student")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
                    .padding(8.dp),
            ) {
                items(stdList, key = {
                    it.rollNo
                }) {
                    StudentItem(it)
                }
            }
        }
    }


}

@Composable
fun StudentItem(std: Student) {
    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        onClick = {

        },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Blue),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.Blue else Color.Green,
            contentColor = Color.Red)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Checkbox(checked = isSelected,
                onCheckedChange = {
                    isSelected = !isSelected
                })
//            Image(
//                colorFilter = ColorFilter.tint(Color.White),
//                modifier = Modifier.size(80.dp),
//                imageVector = Icons.Filled.Person,
//                contentDescription = "Student pic"
//            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${std.name}")
                Text(text = "Roll: ${std.rollNo}")
                Text(text = "Marks: ${std.marks}")
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewStudentList() {
        StudentList()
}