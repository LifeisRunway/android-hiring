package com.example.myapplication.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.components.AgeChooserView
import com.example.myapplication.ui.components.GenderChooserView
import com.example.myapplication.utils.AppFontFamily

object GenderAgeDialog {
    @Composable
    fun Default(
        modifier: Modifier = Modifier,
        username: String?,
        isMaleState: State<Boolean?>,
        selectedAge: State<Int?>,
        onClickGender : (Boolean) -> Unit,
        openAgePopUp: () -> Unit,
        onClickNext: () -> Unit,
    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(18.dp),
            shadowElevation = 2.dp,
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 14.dp,
                    start = 17.dp,
                    end = 17.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.hello_username, username ?: "Username"),
                    fontSize = 14.sp,
                    fontFamily = AppFontFamily.Arial,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.sp,
                    lineHeight = 20.sp,
                    color = colorResource(R.color.secondary_gray)
                )

                Text(
                    stringResource(R.string.tell_about_youself),
                    fontSize = 14.sp,
                    fontFamily = AppFontFamily.Arial,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.black),
                    modifier = Modifier.padding(top = 12.dp)
                )

                GenderChooserView.Default(
                    modifier = Modifier.padding(
                        top = 15.dp,
                        start = 46.dp,
                        end = 46.dp,
                    ),
                    isMaleState = isMaleState,
                    onClickGender = onClickGender
                )

                AgeChooserView.Default(
                    modifier = Modifier.padding(
                        top = 15.dp,
                        start = 46.dp,
                        end = 46.dp,
                    ),
                    selectedAge = selectedAge,
                    onClickAge = openAgePopUp
                )

                NextButton(
                    enabled = isMaleState.value != null && selectedAge.value != null,
                    onClickNext = onClickNext,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }

    @Composable
    fun NextButton(
        enabled: Boolean,
        onClickNext: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Button(
            onClick = onClickNext,
            modifier = modifier.height(30.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = colorResource(R.color.primary_green),
                disabledContainerColor = colorResource(R.color.secondary_gray),
                disabledContentColor = Color.White,
            ),
            enabled = enabled,
            contentPadding = PaddingValues(7.dp)
        ) {
            Text(
                stringResource(R.string.next),
                fontSize = 14.sp,
                fontFamily = AppFontFamily.Arial,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.sp,
                lineHeight = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
            )
        }
    }
}

@Preview
@Composable
fun GenderAgeDialogPreview() {
    GenderAgeDialog.Default(
        username = null,
        isMaleState = remember { mutableStateOf(null) },
        selectedAge = remember { mutableStateOf(null) },
        openAgePopUp = {},
        onClickGender = {},
        onClickNext = {}
    )
}