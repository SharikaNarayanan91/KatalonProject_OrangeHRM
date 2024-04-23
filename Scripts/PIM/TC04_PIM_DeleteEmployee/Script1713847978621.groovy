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

'Create an employee.'
WebUI.callTestCase(findTestCase('CustomFunctions/createEmployee'), [('employeeFirstName') : employeeFirstName, ('employeeMiddleName') : employeeMiddleName
        , ('employeeLastName') : employeeLastName], FailureHandling.STOP_ON_FAILURE)

'Get the employeeFullName.'
employeeFullName = ((((employeeFirstName + ' ') + employeeMiddleName) + ' ') + employeeLastName)

'Search the employee.'
WebUI.callTestCase(findTestCase('CustomFunctions/searchEmployeeWithName'), [('employeeFullName') : employeeFullName], FailureHandling.STOP_ON_FAILURE)

'Click on the delete icon.'
WebUI.click(findTestObject('pimPage/icon_delete'))

'Click on the \'Yes,Delete\' button on delete popup.'
WebUI.click(findTestObject('pimPage/button_Yes, Delete'))

'Search the deleted employee.'
WebUI.callTestCase(findTestCase('CustomFunctions/searchEmployeeWithName'), [('employeeFullName') : employeeFullName], FailureHandling.STOP_ON_FAILURE)

'Verify that No records are found.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/span_No Records Found'), 'No Records Found')

'Logout from the user.'
WebUI.callTestCase(findTestCase('CustomFunctions/logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the browser.'
WebUI.closeBrowser()

