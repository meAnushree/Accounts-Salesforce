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

WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC31')

'Click on 3_5-Order Management profile'
WebUI.click(findTestObject('SFDC/Profiles/3_5-OrderManagement'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

'Login with the user (Leslie Padilla)'
WebUI.click(findTestObject('SFDC/LogInOm'))

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify that all the child account visible along with parent account'
WebUI.verifyElementVisible(findTestObject('SFDC/AllSearchResults'), FailureHandling.OPTIONAL)

'Click on parent account from  search result after searching a text'
WebUI.click(findTestObject('SFDC/ParentAccountLink'))

'Creating a random child account name and set the text in child account field in account creation page\r\n'
WebUI.setText(findTestObject('SFDC/ChildAcName'), childAccountName + new Random().nextInt(10000))

WebUI.click(findTestObject('SFDC/Country'))

'Get the index of the present window'
int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window = (window + 1))

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('SFDC/lookup'), country)

WebUI.click(findTestObject('SFDC/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('SFDC/LookupResult'))

WebUI.switchToWindowIndex(window = (window - 1))

'Click on the save button'
WebUI.click(findTestObject('SFDC/Save'))

WebUI.delay(GlobalVariable.delay)

'Verify the result page after clicking the save button'
WebUI.click(findTestObject('SFDC/VerifySavePage'))

WebUI.comment('TC31, TC32')

'Click on edit button'
WebUI.click(findTestObject('SFDC/Edit'))

'Click on sold to check box'
WebUI.click(findTestObject('SFDC/SoldTo(CosData)'))

'Verifying export screening status should be Unverified'
WebUI.verifyElementVisible(findTestObject('SFDC/ScreeningStatus'), FailureHandling.OPTIONAL)

//'Verifying sfdc status should be prospect'
//WebUI.verifyElementVisible(findTestObject('SFDC/SFDCStatusSet'), FailureHandling.OPTIONAL)
WebUI.callTestCase(findTestCase('SFDC/TC_ValidatingAccountDetails'), [('Url') : 'https://cadence--hfx.sandbox.my.salesforce.com/_ui/common/data/LookupPage?lkfm=editPage&lknm=CF00Nd00000056FdB&lktp=a0H&lksrch=100'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('SFDC/City'), city)

WebUI.setText(findTestObject('SFDC/StateRegion'), state)

WebUI.setText(findTestObject('SFDC/PostalCode'), postalCode)

WebUI.setText(findTestObject('SFDC/Address3'), address)

WebUI.click(findTestObject('SFDC/SendToSAP'))

'Verifying SAP status should be Active'
WebUI.verifyElementVisible(findTestObject('SFDC/SAPStatus'), FailureHandling.OPTIONAL)

'Verifying SAP response should be Ok'
WebUI.verifyElementVisible(findTestObject('SFDC/SAPResponse'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SFDC/CancelButton'))


WebUI.click(findTestObject('SFDC/Dropdown'))

WebUI.click(findTestObject('SFDC/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)




























