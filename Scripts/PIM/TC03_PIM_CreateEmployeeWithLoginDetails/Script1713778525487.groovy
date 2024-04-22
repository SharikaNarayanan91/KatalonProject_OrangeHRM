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

'Login to the user.'
WebUI.callTestCase(findTestCase('CustomFunctions/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the \'PIM\' tab.'
WebUI.click(findTestObject('Object Repository/pimPage/tab_PIM'))

'Verify the \'PIM\' page is displayed.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_PIM'), 'PIM')

'Click on the \'Add\' button.'
WebUI.click(findTestObject('Object Repository/pimPage/button_Add'))

'Enter the \'First name\' of the employee.'
WebUI.setText(findTestObject('Object Repository/pimPage/input_Employee Full Name_firstName'), employeeFirstName)

'Enter the \'Middle name\' of the employee.'
WebUI.setText(findTestObject('Object Repository/pimPage/input_Employee Full Name_middleName'), employeeMiddleName)

'Enter the \'Last name\' of the employee.'
WebUI.setText(findTestObject('Object Repository/pimPage/input_Employee Full Name_lastName'), employeeLastName)

'Click on the \'Create Login details\' toggle button.'
WebUI.click(findTestObject('pimPage/span_Employee Id_oxd-switch-input oxd-switc_efe210'))

'Enter the \'Username\'.'
WebUI.setText(findTestObject('pimPage/input_Username_oxd-input oxd-input--focus'), username)

'Enter the \'Password\'.'
WebUI.setEncryptedText(findTestObject('Object Repository/pimPage/input_Password_oxd-input oxd-input--focus'), '0q7y/FwBuKiBRVXfifFeUA==')

'Enter the \'Confirm Password\'.'
WebUI.setEncryptedText(findTestObject('pimPage/input_Confirm Password_oxd-input oxd-input--focus'), '0q7y/FwBuKiBRVXfifFeUA==')

'Click on the \'Save\' button.'
WebUI.click(findTestObject('pimPage/button_Save'))

'Click on the \'PIM\' tab.'
WebUI.click(findTestObject('pimPage/tab_PIM'))

'Get the employeeFullName.'
employeeFullName = ((((employeeFirstName + ' ') + employeeMiddleName) + ' ') + employeeLastName)

'Enter the \'Employee Name\'.'
WebUI.setText(findTestObject('Object Repository/pimPage/input_employeeFullName'), employeeFullName)

'Click on the \'Search\' button.'
WebUI.click(findTestObject('Object Repository/pimPage/button_Search'))

'Verify the \'First & Middle name\' of the Employee.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_employeeFirstAndMiddleName'), (employeeFirstName + 
    ' ') + employeeMiddleName)

'Verify the \'Last name\' of the Employee.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_employeeLastName'), employeeLastName)

'Click on the \'Delete\' icon.'
WebUI.click(findTestObject('pimPage/icon_delete'))

'Logout from the given user.'
WebUI.callTestCase(findTestCase('CustomFunctions/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the browser.'
WebUI.closeBrowser()

