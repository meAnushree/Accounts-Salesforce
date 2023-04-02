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

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/NewParentAccount'))

'This will generate a random string'
accountName = CustomKeywords.'randomStringGenerate.StringGenerate.randomString'(2)


'Set text in parent account field'
WebUI.setText(findTestObject('SFDC/AccountPage/PAccountName'), parentAccountName + accountName)

'Creating a random child account name and set the text in child account field in account creation page'
WebUI.setText(findTestObject('SFDC/AccountPage/ChildAcName'), childAccountName + accountName)

'Add text in street field'
WebUI.setText(findTestObject('SFDC/AccountCreation/Street'), street)

WebUI.setText(findTestObject('SFDC/AccountCreation/Divison'), division)

'Add text in address3 field'
WebUI.setText(findTestObject('SFDC/AccountCreation/Address1'), address)

//WebUI.setText(findTestObject('SFDC/AccountCreation/Address2'), address2)

WebUI.setText(findTestObject('SFDC/AccountCreation/PostalCode'), postalcode)

'Add text in sub locality field'
WebUI.setText(findTestObject('SFDC/AccountCreation/Sublocality'), sublocality)

'Add text in city field'
WebUI.setText(findTestObject('SFDC/AccountCreation/City'), city)

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

'Add text in state field'
WebUI.setText(findTestObject('SFDC/AccountCreation/State'), state)

'Click on the save button'
WebUI.click(findTestObject('SFDC/AccountPage/Save'))

WebUI.delay(GlobalVariable.delay)

'Verify the result page after clicking the save button'
WebUI.click(findTestObject('SFDC/EditPage/VerifySavePage'))

