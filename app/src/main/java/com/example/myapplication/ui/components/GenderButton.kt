package com.example.myapplication.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.utils.clickableNoRipple

object GenderButton {
    @Composable
    private fun Default(
        @DrawableRes iconRes : Int,
        strokeColor : Color,
        backgroundColor: Color,
        active: Boolean?,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        val shape = RoundedCornerShape(10.dp)

        Surface(
            shape = shape,
            shadowElevation = 4.dp,
            modifier = modifier
                .size(50.dp)
                .border(
                    border = BorderStroke(
                        width = 2.dp,
                        color = if(active == true) strokeColor else Color.White,
                    ),
                    shape = shape
                )
                .clickableNoRipple { onClick.invoke() },
            color = if(active == true) backgroundColor else Color.White
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = "genderButton",
                modifier = Modifier.padding(9.dp)
            )
        }
    }

    @Composable
    fun Male(
        isMaleState: State<Boolean?>,
        onClickGender : (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Default(
            iconRes = R.drawable.maleicon,
            strokeColor = colorResource(R.color.male_gender_stroke),
            backgroundColor = colorResource(R.color.male_gender_background),
            active = isMaleState.value,
            onClick = {
                onClickGender.invoke(true)
            },
            modifier = modifier
        )
    }

    @Composable
    fun Female(
        isMaleState: State<Boolean?>,
        onClickGender : (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Default(
            iconRes = R.drawable.femaleicon,
            strokeColor = colorResource(R.color.female_gender_stroke),
            backgroundColor = colorResource(R.color.female_gender_background),
            active = isMaleState.value?.let { !it },
            onClick = {
                onClickGender.invoke(false)
            },
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun GenderButtonMalePreview() {
    GenderButton.Male(
        modifier = Modifier,
        isMaleState = remember { mutableStateOf(null) },
        onClickGender = {}
    )
}

@Preview
@Composable
fun GenderButtonFemalePreview() {
    GenderButton.Female(
        modifier = Modifier,
        isMaleState = remember { mutableStateOf(null) },
        onClickGender = {}
    )
}