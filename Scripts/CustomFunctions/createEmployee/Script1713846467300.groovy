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

'Click on the \'PIM\' tab.'
WebUI.click(findTestObject('pimPage/tab_PIM'))

'Verify the \'PIM\' page is displayed.'
WebUI.verifyElementText(findTestObject('pimPage/ele_PIM'), 'PIM')

'Click on the \'Add\' button.'
WebUI.click(findTestObject('pimPage/button_Add'))

'Enter the \'First name\' of the employee.'
WebUI.setText(findTestObject('pimPage/input_Employee Full Name_firstName'), employeeFirstName)

'Enter the \'Middle name\' of the employee.'
WebUI.setText(findTestObject('pimPage/input_Employee Full Name_middleName'), employeeMiddleName)

'Enter the \'Last name\' of the employee.'
WebUI.setText(findTestObject('pimPage/input_Employee Full Name_lastName'), employeeLastName)

'Click on the \'Save\' button.'
WebUI.click(findTestObject('pimPage/button_Save'))

