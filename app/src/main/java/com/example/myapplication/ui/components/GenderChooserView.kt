package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.utils.AppFontFamily

object GenderChooserView {
    @Composable
    fun Default(
        modifier: Modifier,
        isMaleState: State<Boolean?>,
        onClickGender : (Boolean) -> Unit
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                stringResource(R.string.gender) + ":",
                fontSize = 14.sp,
                fontFamily = AppFontFamily.Arial,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(R.color.black),
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                GenderButton.Male(isMaleState, onClickGender)
                GenderButton.Female(isMaleState, onClickGender)
            }
        }
    }
}

@Preview
@Composable
fun GenderViewPreview() {
    GenderChooserView.Default(
        modifier = Modifier,
        isMaleState = remember { mutableStateOf(null) },
        onClickGender = {}
    )
}