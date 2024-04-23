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

'Open the browser.'
WebUI.openBrowser('')

'Maximize the window.'
WebUI.maximizeWindow()

'Navigate to URL.'
WebUI.navigateToUrl(GlobalVariable.URL)

'Login to the user.'
WebUI.callTestCase(findTestCase('CustomFunctions/login'), [:], FailureHandling.STOP_ON_FAILURE)

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
WebUI.setText(findTestObject('pimPage/input_Username_oxd-input oxd-input--focus'), newUsername)

'Enter the \'Password\'.'
WebUI.setEncryptedText(findTestObject('Object Repository/pimPage/input_Password_oxd-input oxd-input--focus'), 'KdeBFcnstOMsKd2sbdr6jw==')

'Enter the \'Confirm Password\'.'
WebUI.setEncryptedText(findTestObject('pimPage/input_Confirm Password_oxd-input oxd-input--focus'), 'KdeBFcnstOMsKd2sbdr6jw==')

'Click on the \'Save\' button.'
WebUI.click(findTestObject('pimPage/button_Save'))

'Get the employeeFullName.'
employeeFullName = ((((employeeFirstName + ' ') + employeeMiddleName) + ' ') + employeeLastName)

'Get the user profile name.'
userDropdownName = ((employeeFirstName + ' ') + employeeLastName)

'Wait for the Employee name to display.'
WebUI.waitForElementVisible(findTestObject('pimPage/ele_EmployeeName'), 10)

'Search the employee.'
WebUI.callTestCase(findTestCase('CustomFunctions/searchEmployeeWithName'), [('employeeFullName') : employeeFullName], FailureHandling.STOP_ON_FAILURE)

'Verify the \'First & Middle name\' of the Employee.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_employeeFirstAndMiddleName'), (employeeFirstName + 
    ' ') + employeeMiddleName)

'Verify the \'Last name\' of the Employee.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_employeeLastName'), employeeLastName)

'Logout of the user.'
WebUI.callTestCase(findTestCase('CustomFunctions/logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Enter the new employee username.'
WebUI.setText(findTestObject('Object Repository/loginPage/input_Username_username'), newUsername)

'Enter the new employee password.'
WebUI.setEncryptedText(findTestObject('Object Repository/loginPage/input_Password_password'), 'KdeBFcnstOMsKd2sbdr6jw==')

'Click on the \'Login\' button.'
WebUI.click(findTestObject('Object Repository/loginPage/button_Login'))

'Set the user profile name.'
userDropdownName = ((employeeFirstName + ' ') + employeeLastName)

'Verify the user is loged into new employee account.'
WebUI.verifyElementText(findTestObject('pimPage/ele_userDropdownName'), userDropdownName)

'Logout from the given user.'
WebUI.callTestCase(findTestCase('CustomFunctions/logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the browser.'
WebUI.closeBrowser()

