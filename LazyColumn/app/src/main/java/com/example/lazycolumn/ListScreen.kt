package com.example.lazycolumnnavigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController) {
    val items = List(1_000_000) { "Item $it - The only way to do great work is to love what you do." }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("LazyColumn") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            itemsIndexed(items) { index, item ->
                ListItem(index, item, navController)
            }
        }
    }
}

@Composable
fun ListItem(index: Int, text: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("detail/$index") }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("$index", modifier = Modifier.weight(0.1f))
            Text(text, modifier = Modifier.weight(0.9f))
        }
    }
}
