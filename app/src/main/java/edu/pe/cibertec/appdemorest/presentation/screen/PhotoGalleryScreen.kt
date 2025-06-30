package edu.pe.cibertec.appdemorest.presentation.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import edu.pe.cibertec.appdemorest.data.model.Photo
import edu.pe.cibertec.appdemorest.presentation.component.ErrorView
import edu.pe.cibertec.appdemorest.presentation.component.LoadingView
import edu.pe.cibertec.appdemorest.presentation.viewmodel.PhotoGalleryViewModel
import edu.pe.cibertec.appdemorest.util.UiState

@Composable
fun PhotoGalleryScreen(
    viewModel: PhotoGalleryViewModel = viewModel()
) {
    val photosState by viewModel.photState.collectAsState()

    when (val state = photosState) {
        is UiState.Loading -> LoadingView()
        is UiState.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.data) { photo ->
                    PhotoItem(photo = photo)
                }
            }
        }
        is UiState.Error -> {
            ErrorView(
                message = state.message,
                onRetry = { viewModel.loadPhotos() }
            )
        }
    }
}

@Composable
fun PhotoItem(photo: Photo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box {
            AsyncImage(
                model = photo.thumbmailUrl,
                contentDescription = photo.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
            ) {
                Text(
                    text = photo.title,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(8.dp),
                    maxLines = 2
                )
            }
        }
    }
}