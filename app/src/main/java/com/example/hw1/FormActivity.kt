package com.example.hw1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("FormActivity", "FormActivity called onCreate")
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Display(context = this)
            }
        }
    }

    @Composable
    fun Display(context: Context) {
        var name by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var termsOfUseAgree by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Insert your name") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Insert your date of birth") },
                modifier = Modifier.fillMaxWidth()
            )
            Row {
                Checkbox(
                    checked = termsOfUseAgree,
                    onCheckedChange = { termsOfUseAgree = it }
                )
                Text(text = "I agree to the terms of use")
            }
            Button(
                onClick = {
                    val intent = Intent(context, DataShowActivity::class.java).apply {
                        putExtra("name", name)
                        putExtra("dateOfBirth", date)
                        putExtra("termsAgreed", termsOfUseAgree)
                    }
                    startActivityForResult(intent, 123456)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Submit")
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val name = data?.getStringExtra("name")
            val date = data?.getStringExtra("dateOfBirth")
            val termsAgreed = data?.getBooleanExtra("termsAgreed", false)
            Log.i("FormActivity", "Name: $name")
            Log.i("FormActivity", "Date of birth: $date")
            Log.i("FormActivity", "Terms of use agreed: $termsAgreed")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("FormActivity", "FormActivity called OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FormActivity", "FormActivity called OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FormActivity", "FormActivity called OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FormActivity", "FormActivity called OnDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FormActivity", "FormActivity called OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("FormActivity", "FormActivity called OnRestart")
    }


}