package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
//    Greeting("Android")
    Conversation(
        list = listOf(
            "Jim: One of the best salesman but a little lazy. He is tall and married to Pam.",
            "Pam: Started as a receptionist, Pam has become a salesman. She is also an artist but hard to catch up with the new technology.",
            "Michel: The manger of Scranton branch of Dunder Mifflin. He is a very jolly person. He has a passion for stand up comedy and he also like improv.",
            "Dwight: He is a very hardworking salesman in Dunder Mifflin. He also owns a farm. He is man a who goes by the book."
        )
    )
}

@Composable
fun Greeting(name: String) {
    Column {
        Spacer(modifier = Modifier.height(20.dp))

        Row {
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_background),
//                contentDescription = "This is a sample image",
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//            )

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 10.dp,
                color = colorResource(id = R.color.purple_500),
            ) {
                Text(
                    text = "This is some text in row 1",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        Text(
            text = "Hello there $name!",
            color = colorResource(id = R.color.purple_500),
            modifier = Modifier.padding(10.dp)
        )
        Text(text = "Namaste $name!", modifier = Modifier.padding(10.dp))
        Text(text = "This is some text", modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun Conversation(list: List<String>) {
    LazyColumn(Modifier.padding(15.dp)) {
        items(list) { message ->
            messageItem(msg = message)
        }
    }
}

@Composable
fun messageItem(msg: String) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val surfaceColor by animateColorAsState(
        if (isExpanded) colorResource(id = R.color.purple_500) else colorResource(
            id = R.color.white
        )
    )

    Surface(
        color = surfaceColor,
        modifier = Modifier
            .animateContentSize(    )
    ) {
        Text(
            text = msg,
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            modifier = Modifier
                .clickable {
                    isExpanded = !isExpanded
                }
                .padding(10.dp)
        )
    }

    Spacer(modifier = Modifier.height(10.dp))
}

fun showToast(msg: String) {
//    Toast.makeText(rememberCompositionContext(),"Hello",Toast.LENGTH_SHORT)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            App()
        }
    }
}