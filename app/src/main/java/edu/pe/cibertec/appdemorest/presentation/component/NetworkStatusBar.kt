package edu.pe.cibertec.appdemorest.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun NetworkStatusBar(
    isConnected: Boolean = true
) {
    AnimatedVisibility(
        visible = !isConnected,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.error)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "No internet connection",
                color = androidx.compose.material3.MaterialTheme.colorScheme.onError,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
            )
        }
    }
}