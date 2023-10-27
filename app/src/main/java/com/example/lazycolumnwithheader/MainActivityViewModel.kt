package com.example.lazycolumnwithheader

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel()  {

    //  List of data simulating user data that would be stored in a database or in the cloud
    private val names = listOf(
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

    fun getAllContactNames(): Map<Char, List<String>> {
        return names
    }


}