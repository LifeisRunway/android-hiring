package com.example.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.utils.AppFontFamily
import com.example.myapplication.utils.clickableNoRipple

object AgeView {
    @Composable
    fun Default(
        age: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            modifier = modifier
                .size(110.dp, 30.dp)
                .clickableNoRipple { onClick.invoke() },
            color = colorResource(R.color.age_view_background)
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(horizontal = 9.dp),
            ) {
                Text(
                    age,
                    fontSize = 14.sp,
                    fontFamily = AppFontFamily.Arial,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.sp,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .align(Alignment.Center)
                )
                Image(
                    painter = painterResource(R.drawable.arrow_down),
                    contentDescription = "ageViewArrow",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Preview
@Composable
fun AgeViewPreview() {
    AgeView.Default(
        modifier = Modifier,
        age = stringResource(R.string.age_placeholder),
        onClick = {}
    )
}