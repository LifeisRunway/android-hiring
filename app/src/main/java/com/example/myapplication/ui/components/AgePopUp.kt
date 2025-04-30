package com.example.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.content.GenderAgeDialog
import com.example.myapplication.utils.AppFontFamily
import com.example.myapplication.utils.clickableNoRipple

object AgePopUp {
    @Composable
    fun Default(
        ages: Array<Int>,
        selectedAge: Int?,
        onClickAge: (Int) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.size(110.dp, 167.dp),
            shadowElevation = 4.dp,
            color = colorResource(R.color.age_view_background)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(vertical = 2.dp)
            ) {
                itemsIndexed(ages) { index, age ->
                    Box(
                        modifier = Modifier
                            .clickableNoRipple {
                                onClickAge.invoke(age)
                            }
                    ) {
                        Text(
                            age.toString(),
                            fontSize = 14.sp,
                            fontFamily = AppFontFamily.Arial,
                            fontWeight = if(selectedAge == age) FontWeight.Bold else FontWeight.Normal,
                            letterSpacing = 0.sp,
                            lineHeight = 16.sp,
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
                        )

                        if(selectedAge == age) {
                            Image(
                                painter = painterResource(R.drawable.checkmark),
                                contentDescription = "checkmark",
                                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 8.dp)
                            )
                        }
                    }

                    if(index != ages.lastIndex) {
                        HorizontalDivider(
                            color = colorResource(R.color.divider)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AgePopUpPreview() {
    AgePopUp.Default(
        ages = (16..30).toList().toTypedArray(),
        selectedAge = 18,
        onClickAge = {}
    )
}

