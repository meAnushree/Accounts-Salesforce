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

'This will navigate to account page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : search], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/NewParentAccount'))

WebUI.comment('TC96')

'This will generate a random string'
parentAccountName = CustomKeywords.'randomStringGenerate.StringGenerate.randomString'(4)

'This will generate a random string'
childAccountName = CustomKeywords.'randomStringGenerate.StringGenerate.randomString'(41)

'Set text in parent account field'
WebUI.setText(findTestObject('SFDC/AccountPage/PAccountName'), accountName + parentAccountName)

'Creating a random child account name and set the text in child account field in account creation page'
WebUI.setText(findTestObject('SFDC/AccountPage/ChildAcName'), childAccountName)

WebUI.click(findTestObject('SFDC/EditPage/Country'))

'Get the index of the present window'
int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('SFDC/EditPage/lookup'), country)

WebUI.click(findTestObject('SFDC/Navigation/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('SFDC/AccountPage/LookupResult'))

WebUI.switchToWindowIndex(window)

'Click on the save button'
WebUI.click(findTestObject('SFDC/AccountPage/Save'))

WebUI.delay(GlobalVariable.delay)

WebUI.verifyElementVisible(findTestObject('SFDC/AdditionalInfo/AccountError'), FailureHandling.STOP_ON_FAILURE)

'Verify error message in the account creation page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ReadErrorMsg'), [('error') : error], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC97')

'Creating a random child account name and set the text in child account field in account creation page'
WebUI.setText(findTestObject('SFDC/AccountPage/ChildAcName'), accountName + parentAccountName)

'Click on the save button'
WebUI.click(findTestObject('SFDC/AccountPage/Save'))

WebUI.delay(GlobalVariable.delay)

WebUI.comment('TC98')

WebUI.setText(findTestObject('SFDC/Global/GlobalSearchBox'), search)

WebUI.click(findTestObject('SFDC/Global/GlobalSearchButton'))

'Verifying that `Duplicate` parent account not exist in search results'
String accountName = WebUI.getText(findTestObject('SFDC/AccountPage/FirstParentAccount'))

WebUI.verifyNotEqual(accountName, search)

