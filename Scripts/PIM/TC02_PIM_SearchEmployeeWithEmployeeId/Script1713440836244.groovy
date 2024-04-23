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

'Login to the given user.'
WebUI.callTestCase(findTestCase('CustomFunctions/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Create an employee.'
WebUI.callTestCase(findTestCase('CustomFunctions/createEmployee'), [('employeeFirstName') : employeeFirstName, ('employeeMiddleName') : employeeMiddleName
        , ('employeeLastName') : employeeLastName], FailureHandling.STOP_ON_FAILURE)

'Click on the \'PIM\' tab.'
WebUI.click(findTestObject('pimPage/tab_PIM'))

'Get the employeeFullName.'
employeeFullName = ((((employeeFirstName + ' ') + employeeMiddleName) + ' ') + employeeLastName)

'Enter the \'Employee Name\'.'
WebUI.setText(findTestObject('Object Repository/pimPage/input_employeeFullName'), employeeFullName)

'Click on the \'Search\' button.'
WebUI.click(findTestObject('Object Repository/pimPage/button_Search'))

'Get the employeeID.'
employeeID = WebUI.getText(findTestObject('pimPage/ele_employeeId'))

'Click on the \'PIM\' tab.'
WebUI.click(findTestObject('pimPage/tab_PIM'))

'Enter the \'Employee Name\'.'
WebUI.setText(findTestObject('pimPage/input_Employee Id_Search'), employeeID)

'Click on the \'Search\' button.'
WebUI.click(findTestObject('Object Repository/pimPage/button_Search'))

'Verify the \'First & Middle name\' of the Employee.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_employeeFirstAndMiddleName'), (employeeFirstName + 
    ' ') + employeeMiddleName)

'Verify the \'Last name\' of the Employee.'
WebUI.verifyElementText(findTestObject('Object Repository/pimPage/ele_employeeLastName'), employeeLastName)

'Click on the \'Delete\' icon.'
WebUI.click(findTestObject('pimPage/icon_delete'))

'Click on the \'Yes,Delete\' button on delete popup.'
WebUI.click(findTestObject('pimPage/button_Yes, Delete'))

'Logout from the user.'
WebUI.callTestCase(findTestCase('CustomFunctions/logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the browser.'
WebUI.closeBrowser()

