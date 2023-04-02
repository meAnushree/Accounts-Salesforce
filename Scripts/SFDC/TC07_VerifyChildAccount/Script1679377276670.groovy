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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.comment('TC65')

'Add text in gss index field'
WebUI.setText(findTestObject('SFDC/EditPage/GSSIndex'), gssIndex, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

'Get value from excel sheet'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/AllMessages', 'Invalid Data', 'Condition')

invalid = findTestData('SFDC/AllMessages').getValue('Message', message)

'Verify that gss index field comes up with an error'
String output = WebUI.getText(findTestObject('SFDC/ErrorMsg/InvalidDataError'))

if (output.contains(invalid)) {
    WebUI.click(findTestObject('SFDC/AccountPage/CancelButton'))
}

'Click on "+" icon'
WebUI.click(findTestObject('SFDC/Navigation/AllTab'))

'Click on accounts tab'
WebUI.click(findTestObject('SFDC/Navigation/Accounts'))

WebUI.comment('TC68, TC69')

'Click on the fisrt parent account'
WebUI.click(findTestObject('SFDC/AccountPage/FirstParentAccount'))

WebUI.delay(GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Makes the channel type indirect'
WebUI.click(findTestObject('SFDC/EditPage/ChannelType'))

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

'Click on the account site tab'
WebUI.click(findTestObject('SFDC/AccountPage/AccountSites'))

'Verify user shild redirect to account site page'
WebUI.verifyElementVisible(findTestObject('SFDC/AdditionalInfo/OpenAccSites'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.comment('TC70')

'Verifying export screening status field of pick list type should be added on the account layout.'
WebUI.verifyElementPresent(findTestObject('SFDC/EditPage/ExportScreeningStatus'), GlobalVariable.delay)

WebUI.comment('TC71')

'Verifying export screening status has the option "Match"'
WebUI.verifyOptionPresentByValue(findTestObject('SFDC/EditPage/ExportScreeningStatus'), match, false, GlobalVariable.delay)

'Verifying export screening status has the option "No Match"'
WebUI.verifyOptionPresentByValue(findTestObject('SFDC/EditPage/ExportScreeningStatus'), noMatch, false, GlobalVariable.delay)

'Verifying export screening status has the option "Potential Match"'
WebUI.verifyOptionPresentByValue(findTestObject('SFDC/EditPage/ExportScreeningStatus'), potential, false, GlobalVariable.delay)

WebUI.comment('TC72')

WebUI.verifyOptionPresentByValue(findTestObject('SFDC/EditPage/ExportScreeningStatus'), unverified, false, GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/AccountPage/CancelButton'))

WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC73')

'Create a new account'
WebUI.click(findTestObject('SFDC/AccountPage/NewParentAccount'))

'Set text in parent account field'
WebUI.setText(findTestObject('SFDC/AccountPage/PAccountName'), parentAccountName + new Random().nextInt(10000))

'Creating a random child account name and set the text in child account field in account creation page'
WebUI.setText(findTestObject('SFDC/AccountPage/ChildAcName'), childAccountName + new Random().nextInt(10000))

WebUI.click(findTestObject('SFDC/EditPage/Country'))

'Get the index of the present window'
int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window = (window + 1))

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('SFDC/EditPage/lookup'), country)

WebUI.click(findTestObject('SFDC/Navigation/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('SFDC/AccountPage/LookupResult'))

WebUI.switchToWindowIndex(window = (window - 1))

'Click on the save button'
WebUI.click(findTestObject('SFDC/AccountPage/Save'))

WebUI.delay(GlobalVariable.delay)

'Verify the result page after clicking the save button'
WebUI.click(findTestObject('SFDC/EditPage/VerifySavePage'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Verifying SFDC status is prospect'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/SFDCStatusSet'), FailureHandling.STOP_ON_FAILURE)

'Verifying export screening status is unverified'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/ScreeningStatus'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC86.02')

'Get value from excel file'
sales = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Inside Sales', 'Type')

insideSales = findTestData('SFDC/Profiles').getValue('Profile', sales)

'Clicking on profile 2_1 Inside-Sales'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : insideSales], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Verify that export screening status has only read option'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/ScreeningStatusInactive'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/CancelButton'))

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))


