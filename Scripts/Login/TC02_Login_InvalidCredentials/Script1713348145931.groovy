import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Open the browser'
WebUI.openBrowser('')

'Maximize the window.'
WebUI.maximizeWindow()

'Navigate to the given URL.'
WebUI.navigateToUrl(GlobalVariable.URL)

'Enter the username.'
WebUI.setText(findTestObject('Object Repository/loginPage/input_Username_username'), username)

'Enter the password.'
WebUI.setEncryptedText(findTestObject('Object Repository/loginPage/input_Password_password'), password)

'Click on the \'Login\' button.'
WebUI.click(findTestObject('Object Repository/loginPage/button_Login'))

'Get the actual error message displayed.'
actualErrorMessage = WebUI.getText(findTestObject('loginPage/ele_invalidCredentials_errorMessage'), FailureHandling.STOP_ON_FAILURE)

'Verify the error message displayed is as expected.'
WebUI.verifyEqual(actualErrorMessage, errorMessage)

'Close the browser.'
WebUI.closeBrowser()

