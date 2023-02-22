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

WebUI.callTestCase(findTestCase('SFDC/TC01_HFXLogIn'), [('url') : 'https://cadence.oktapreview.com/', ('username') : 'internalcossupportadmin@cadence.com'
        , ('password') : 'Cdns1234'], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC01')

'Click on "+" icon'
WebUI.click(findTestObject('SFDC/AllTab'))

'Click on accounts tab'
WebUI.click(findTestObject('SFDC/Accounts'))

'Click on new button'
WebUI.click(findTestObject('SFDC/NewButton'))

'Verifying account name search box is present'
WebUI.verifyElementPresent(findTestObject('SFDC/AccountsNameSearch'), GlobalVariable.delay)

'Verifying search button in lookup page is present'
WebUI.verifyElementPresent(findTestObject('SFDC/LookUpSearchButton'), GlobalVariable.delay)

'Get the text under the search box'
String lookUpMsg = WebUI.getText(findTestObject('SFDC/LookUpMsg'), FailureHandling.STOP_ON_FAILURE)

'Check that text under the text box is matched'
if (lookUpMsg.equals(accountPageMsg)) {
    println('True')
}

WebUI.comment('TC2.1')

'Single keyword text added in search box'
WebUI.setText(findTestObject('SFDC/AccountsNameSearch'), searchAcName)

//'Get the text from input box'
//String Accname = WebUI.getAttribute(findTestObject('SFDC/AccountsNameSearch'), 'value')
//
//'Verify that text is added in search box'
//WebUI.verifyEqual(Accname, searchAcName)
'Click on search button'
WebUI.click(findTestObject('SFDC/LookUpSearchButton'))

def listofResults = WebUI.findWebElements(findTestObject('SFDC/SearchResults'), GlobalVariable.delay)

int length = listofResults.size()

println(length)

WebUI.comment('TC03')

'Multiple keyword text added in search box '
WebUI.setText(findTestObject('SFDC/AccountsNameSearch'), searchAcName2)

//String Accname2 = WebUI.getAttribute(findTestObject('SFDC/AccountsNameSearch'), 'value')
//
//WebUI.verifyEqual(Accname2, searchAcName2)
'Click on search button'
WebUI.click(findTestObject('SFDC/LookUpSearchButton'))

WebUI.comment('TC04')

'Random text added in search box'
WebUI.setText(findTestObject('SFDC/AccountsNameSearch'), garbageValue)

//String GarbageVal = WebUI.getAttribute(findTestObject('SFDC/AccountsNameSearch'), 'value')
//
//WebUI.verifyEqual(GarbageVal, garbageValue)
'Click on search button'
WebUI.click(findTestObject('SFDC/LookUpSearchButton'))

'Verify no records found text visible after searching random text'
WebUI.verifyElementVisible(findTestObject('SFDC/NoRecFound'), FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC5')

'Multiple keyword ext added in search box '
WebUI.setText(findTestObject('SFDC/AccountsNameSearch'), searchAcName2)

WebUI.click(findTestObject('SFDC/LookUpSearchButton'))

'Verify that after searching, search results along with three messages is visible'
WebUI.verifyElementVisible(findTestObject('SFDC/SearchResultsMsg'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('SFDC/ThreeMsg'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/NewParentAccount'))

'Verify that after clicking on new parent account, account creation page is open'
WebUI.verifyElementVisible(findTestObject('SFDC/CreateAccountPage'), FailureHandling.STOP_ON_FAILURE)

