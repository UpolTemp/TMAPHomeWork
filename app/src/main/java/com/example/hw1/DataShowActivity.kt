package com.example.hw1


import android.app.Activity
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DataShowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DataShowActivity", "MainActivity called onCreate")
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Display()
            }
        }
    }

    @Composable
    fun Display() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val name = intent.getStringExtra("name") ?: ""
            val dateOfBirth = intent.getStringExtra("dateOfBirth") ?: ""
            val termsAgreed = intent.getBooleanExtra("termsAgreed", false)
            Column {
                Text(text = ("Inserted name: $name"))
                Text(text = ("Inserted date of birth: $dateOfBirth"))
                Text(text = ("Agreed with terms of use: $termsAgreed"))
                Button(
                    onClick = {
                        val resultIntent = Intent()
                        resultIntent.putExtra("name", name)
                        resultIntent.putExtra("dateOfBirth", dateOfBirth)
                        resultIntent.putExtra("termsAgreed", termsAgreed)
                        setResult(Activity.RESULT_OK, resultIntent)
                        finish()
                    },
                    modifier = Modifier.padding(30.dp)
                ) {
                    Text(text = "Confirm")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("FormActivity", "DataShowActivity called OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FormActivity", "DataShowActivity called OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FormActivity", "DataShowActivity called OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FormActivity", "DataShowActivity called OnDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FormActivity", "DataShowActivity called OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("FormActivity", "DataShowActivity called OnRestart")
    }
}