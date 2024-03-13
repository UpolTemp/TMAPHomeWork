package com.example.hw1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("FormActivity", "MainActivity called onCreate")
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CreateButton();
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("FormActivity", "MainActivity called OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FormActivity", "MainActivity called OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FormActivity", "MainActivity called OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FormActivity", "MainActivity called OnDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FormActivity", "MainActivity called OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("FormActivity", "MainActivity called OnRestart")
    }
}


@Composable
fun CreateButton() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                val intent = Intent(context, FormActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Proceed to Form")
        }
    }
}

