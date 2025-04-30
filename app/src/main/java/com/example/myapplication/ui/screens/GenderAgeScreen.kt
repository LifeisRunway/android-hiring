package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.AgePopUp
import com.example.myapplication.ui.content.GenderAgeDialog

object GenderAgeScreen {
    @Composable
    fun Default(
        username : String?,
        ages : Array<Int>,
        isMaleState: State<Boolean?>,
        onClickGender : (Boolean) -> Unit,
        selectedAge: State<Int?>,
        onSelectAge: (Int) -> Unit,
        onClickNext : () -> Unit
    ) {

        val agePopUpState = remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background_green))
        ) {
            GenderAgeDialog.Default(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 13.dp),
                username = username,
                isMaleState = isMaleState,
                selectedAge = selectedAge,
                onClickGender = onClickGender,
                openAgePopUp = {
                    agePopUpState.value = true
                },
                onClickNext = onClickNext
            )

            if(agePopUpState.value) {
                AgePopUp.Default(
                    ages = ages,
                    selectedAge = selectedAge.value,
                    modifier = Modifier
                        .padding(end = 76.dp, top = 130.dp)
                        .align(Alignment.CenterEnd),
                    onClickAge = {
                        onSelectAge.invoke(it)
                        agePopUpState.value = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun GenderAgeScreenPreview() {
    GenderAgeScreen.Default(
        username = null,
        ages = (16..30).toList().toTypedArray(),
        isMaleState = remember { mutableStateOf(null) },
        selectedAge = remember { mutableStateOf(null) },
        onClickGender = {},
        onSelectAge = {},
        onClickNext = {}
    )
}