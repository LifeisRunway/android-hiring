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

object AgeChooserView {
    @Composable
    fun Default(
        modifier: Modifier,
        selectedAge: State<Int?>,
        onClickAge: () -> Unit
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                stringResource(R.string.age) + ":",
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
                AgeView.Default(
                    age = selectedAge.value?.toString() ?: stringResource(R.string.age_placeholder),
                    onClick = onClickAge
                )
            }
        }
    }


}

@Preview
@Composable
fun AgeChooserViewPreview() {
    AgeChooserView.Default(
        modifier = Modifier,
        selectedAge = remember { mutableStateOf(null) },
        onClickAge = {}
    )
}

