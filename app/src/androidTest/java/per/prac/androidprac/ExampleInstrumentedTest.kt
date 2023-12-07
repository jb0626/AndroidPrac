package per.prac.androidprac

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import boxLayout

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("per.prac.androidprac", appContext.packageName)
    }

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun androidImageExistTest() {
        composeRule.setContent {
            boxLayout()
        }
        composeRule.onNodeWithTag("Android_Image").assertExists()
    }

    @Test
    fun androidImageDisplayTest() {
        composeRule.setContent {
            boxLayout()
        }
        composeRule.onNodeWithTag("Android_Image").assertIsDisplayed()
    }

}