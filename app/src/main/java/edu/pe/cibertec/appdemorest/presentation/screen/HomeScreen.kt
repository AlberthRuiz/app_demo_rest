package edu.pe.cibertec.appdemorest.presentation.screen

import android.R
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Preview(
    showBackground = true
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

) {
    Scaffold(
        topBar = {
            TopAppBar (
                title = {
                    Text(
                        "App demo rest services",
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
                )

            )
        }
    ){
        paddingValues ->
            Column (modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Esta app es una demo de consumo de servicios rest utilizando retrofit.",
                    style= MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(10.dp))
                MenuButton(
                    title = "Posts",
                    descripcin = "Ver lista de los post publicados",
                    icon = Icons.Default.DateRange,
                    onClick = {

                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                MenuButton(
                    title = "Usuarios",
                    descripcin = "Ver lista de usuario registrados",
                    icon = Icons.Default.Face,
                    onClick = {

                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                MenuButton(
                    title = "Galeria de fotos",
                    descripcin = "Ver fotos multimedia.",
                    icon = Icons.Default.FavoriteBorder,
                    onClick = {

                    }
                )

            }
    }
}

@Composable
fun MenuButton(
    title: String,
    descripcin: String,
    icon: ImageVector,
    onClick : ()-> Unit
){
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    )
    {
        Row (
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.size(50.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(15.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = descripcin,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

    }
}