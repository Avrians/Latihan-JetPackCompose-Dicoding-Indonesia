package com.avrians.mycomposetesting.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.avrians.mycomposetesting.R
import com.avrians.mycomposetesting.ui.theme.MyComposeTestingTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppTest{
    @get: Rule
//    val composeTestRule = createComposeRule()
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            MyComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_area_of_rectangle_correct() {
//        composeTestRule.onNodeWithText("Masukkan panjang").performTextInput("3")
//        composeTestRule.onNodeWithText("Masukkan lebar").performTextInput("4")
//        composeTestRule.onNodeWithText("Hitung!").performClick()
//        composeTestRule.onNodeWithText("Hasil: 12.0").assertExists()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length)).performTextInput("3")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width)).performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.count)).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 12.0)).assertExists()
    }

    @Test
    fun wrong_input_not_calculated(){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_length)).performTextInput("..3")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_width)).performTextInput("4")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.count)).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.result, 0.0)).assertExists()
    }
}