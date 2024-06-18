package com.example.stylosenses.presentations.screen.ml_feature_screen

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.provider.MediaStore
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.stylosensess.R
import com.example.stylosenses.presentations.graph.home.ShopHomeScreen
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


@Composable
//fun FeatureScreen3(navController: NavHostController) {
//    val imageUri by remember { mutableStateOf<String?>(null) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 16.dp)
//            .padding(top = 16.dp)
//    ) {
//        // Header
//        Text(
//            text = "Feature",
//            fontWeight = FontWeight.Bold,
//            fontSize = 24.sp,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        // Content
//        Spacer(modifier = Modifier.weight(1f))
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1f)
//                .background(Color.LightGray, RoundedCornerShape(10.dp)),
//            contentAlignment = Alignment.Center
//        ) {
//            if (imageUri != null) {
//                Image(
//                    painter = painterResource(id = R.drawable.plus_icon), //placeholder// replace with actual image resource or uri
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//            } else {
//                IconButton(
//                    onClick = { navController.navigate(ShopHomeScreen.FeatureScreen4.route) },
//                    modifier = Modifier
//                        .size(64.dp)
//                        .background(Color.White, CircleShape)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Add ,//CameraAlt,
//                        contentDescription = "Take Picture",
//                        tint = Color.Cyan, //Purple500,
//                        modifier = Modifier.size(32.dp)
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Bottom Navigation
////        BottomNavigationBar(navController = navController)
//    }
//}

fun FeatureScreen3(navController: NavHostController) {
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
//    val preview = Preview.Builder().build() //Builder().build()
    val previewView = remember {
        PreviewView(context)
    }
    val cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
    val imageCapture = remember {
        ImageCapture.Builder().build()
    }
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector,
//            preview,
            imageCapture)
//        preview.setSurfaceProvider(previewView.surfaceProvider)
    }
    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
        Button(onClick = { captureImage(imageCapture, context) }) {
            Text(text = "Capture Image")
        }
    }
}

private fun captureImage(imageCapture: ImageCapture, context: Context) {
    val name = "CameraxImage.jpeg"
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
        }
    }
    val outputOptions = ImageCapture.OutputFileOptions
        .Builder(
            context.contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        )
        .build()
    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                println("Successs")
            }

            override fun onError(exception: ImageCaptureException) {
                println("Failed $exception")
            }

        })
}

private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                continuation.resume(cameraProvider.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }