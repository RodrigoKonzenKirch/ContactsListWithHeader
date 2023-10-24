package com.example.lazycolumnwithheader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycolumnwithheader.ui.theme.LazyColumnWithHeaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val names = listOf(
            "John Smith",
            "Jane Doe",
            "Michael Johnson",
            "Emily Davis",
            "David Brown",
            "Sarah Miller",
            "James Wilson",
            "Linda Moore",
            "Robert Taylor",
            "Patricia Anderson",
            "William Thomas",
            "Jennifer Jackson",
            "Charles White",
            "Mary Harris",
            "Joseph Martin",
            "Susan Thompson",
            "Thomas Garcia",
            "Jessica Martinez",
            "Daniel Robinson",
            "Karen Clark",
            "Paul Rodriguez",
            "Nancy Lewis",
            "Brian Walker",
            "Barbara Hall",
            "Mark Allen",
            "Elizabeth Young",
            "Donald Hernandez",
            "Angela King",
            "George Wright",
            "Laura Green",
            "Kenneth Adams",
            "Margaret Baker",
            "Steven Gonzalez",
            "Dorothy Nelson",
            "Edward Carter ",
            "Pamela Mitchell ",
            "Ronald Perez ",
            "Sharon Roberts ",
            "Anthony Turner ",
            "Ruth Phillips"
        ).sorted().groupBy{ it[0] }

        val namesList = names.map {
            Category(
                name = it.key.toString(),
                items = it.value
            )
        }

        setContent {
            LazyColumnWithHeaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactsListWithHeader(categories = namesList)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContactsListWithHeader(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        categories.forEach { category ->
            stickyHeader {
                CategoryHeader(category.name)
            }
            items(category.items) { text ->
                CategoryItem(text)
            }
        }
    }
}

@Composable
private fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

@Composable
private fun CategoryItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

data class Category(
    val name: String,
    val items: List<String>
)