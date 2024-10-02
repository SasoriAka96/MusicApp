package com.example.musicapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicapp.ui.theme.MusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                MusicApp()
            }
        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true,
    device = "id:pixel_8_pro"
)
@Preview(
    showBackground = true, showSystemUi = true,
    device = "spec:width=448dp,height=998dp,orientation= landscape"
)
@Composable
fun MusicApp() {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {

            LandscapeScreenComposition()
        }

        else -> {
            VerticalScreenComposition()
        }
    }

}

@Composable
fun VerticalScreenComposition() {
    var play by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp)
                .padding(start = 50.dp)
                .padding(end = 50.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {

            Image(
                painter = painterResource(R.drawable.sharealtsquare),
                contentDescription = null,
                modifier = Modifier.size(20.dp)

            )
            Spacer(modifier = Modifier.weight(1f))
            Slider(
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color.White,
                    inactiveTrackColor = Color.Gray
                ),
                value = 0.75f,
                onValueChange = {},
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(152.dp)
                    .height(20.dp)
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .height(350.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.fallenstars),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(4.dp))
                    .border(2.dp, Color.White)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                fontSize = 20.sp,
                text = "Fallen Star",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)

            )
            Text(
                fontSize = 15.sp,
                text = "The neighbourhood",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)
                .padding(end = 50.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.music),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 13.sp,
                text = "0:55",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 49.dp)
            )
            Text(
                fontSize = 13.sp,
                text = "3:44",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 298.dp)
            )
        }

        Slider(
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.White,
                inactiveTrackColor = Color.Gray
            ),
            value = 0.25f,
            onValueChange = {},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp)
                .padding(start = 43.dp, end = 43.dp)
                .height(50.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(start = 50.dp)
                .padding(end = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Image(
                painter = painterResource(R.drawable.stepbackward),
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(
                    if (play) R.drawable.pausecircle else R.drawable.playcircle
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        play = !play
                    }
            )
            Image(
                painter = painterResource(R.drawable.stepforward),
                contentDescription = null,
                modifier = Modifier.size(35.dp)

            )
        }

    }
}

@Composable
fun LandscapeScreenComposition() {
    var play by remember { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(start = 100.dp)
                .padding(end = 100.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {

            Image(
                painter = painterResource(R.drawable.sharealtsquare),
                contentDescription = null,
                modifier = Modifier.size(20.dp)

            )
            Spacer(modifier = Modifier.weight(1f))
            Slider(
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color.White,
                    inactiveTrackColor = Color.Gray
                ),
                value = 0.75f,
                onValueChange = {},
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(152.dp)
                    .height(20.dp)
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(200.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.fallenstars),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(4.dp))
                    .border(2.dp, Color.White)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                fontSize = 13.sp,
                text = "Fallen Star",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                fontSize = 10.sp,
                text = "The neighbourhood",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .align(Alignment.CenterHorizontally)
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(start = 100.dp)
                .padding(end = 100.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.music),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )
            Image(
                painter = painterResource(R.drawable.stepbackward),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Image(
                painter = painterResource(
                    if (play) R.drawable.pausecircle else R.drawable.playcircle
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        play = !play
                    }
            )
            Image(
                painter = painterResource(R.drawable.stepforward),
                contentDescription = null,
                modifier = Modifier.size(20.dp)

            )
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 7.sp,
                text = "0:55",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 100.dp)
            )

            Text(
                fontSize = 7.sp,
                text = "3:44",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 775.dp)
            )

        }
        Slider(
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.White,
                inactiveTrackColor = Color.Gray
            ),
            value = 0.25f,
            onValueChange = {},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 90.dp, end = 90.dp)
                .height(50.dp)

        )


    }
}