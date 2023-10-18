package com.example.jettip

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettip.ui.theme.JetTipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTipTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var textMail by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(top = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = textMail,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "email"
                )
            },
            onValueChange = { newText -> textMail = newText },
            placeholder = { Text(text = context.getString(R.string.enter_your_mail)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(value = textPassword,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock, contentDescription = "password"
                )
            },
            onValueChange = { password ->
                textPassword = password
            },
            placeholder = { Text(text = context.getString(R.string.enter_your_password)) },
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(modifier = Modifier
            .height(64.dp)
            .width(144.dp), onClick = {

            if (!textMail.isNullOrEmpty() && !textPassword.isNullOrEmpty()) {
                if (textMail.equals("m.cagri0205@gmail.com") && textPassword.equals("123456")) {
                    writeToast(context, context.getString(R.string.basarili))
                } else {
                    writeToast(context, context.getString(R.string.basarisiz))
                }
            } else {
                writeToast(context, context.getString(R.string.basarisiz))
            }
        }) {
            Text(text = context.getString(R.string.sign_in))
        }
    }
}

private fun writeToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetTipTheme {
        MyApp()
    }
}