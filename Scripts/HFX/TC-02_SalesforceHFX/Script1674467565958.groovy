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

WebUI.callTestCase(findTestCase('HFX/TC-01_LogInPage'), [('Url') : 'https://cadence.oktapreview.com/', ('Username') : 'internalcossupportadmin@cadence.com'
        , ('Password') : 'Cdns1234'], FailureHandling.STOP_ON_FAILURE)

'click on SalesforceHfx.com'
WebUI.click(findTestObject('HFX/SalesforseHFX/SalesforceHFX'), GlobalVariable.delay)

'switch to Salesforce tab'
WebUI.switchToWindowIndex(1)

'set text in the serach box to search a user\r\n'
WebUI.setText(findTestObject('HFX/SalesforseHFX/SearchBox'), search)

WebUI.click(findTestObject('HFX/SalesforseHFX/SearchButton'), GlobalVariable.delay)

WebUI.delay(5)

'click on a people from the search results'
WebUI.click(findTestObject('HFX/SalesforseHFX/People'))

'click user action menu'
WebUI.click(findTestObject('HFX/SalesforseHFX/UserActionMenu'))

'choose user details from user action menu\r\n'
WebUI.click(findTestObject('HFX/SalesforseHFX/UserDetails'))

'click on log in button'
WebUI.click(findTestObject('HFX/SalesforseHFX/userLogIn'))

'click "+" icon'
WebUI.click(findTestObject('HFX/SalesforseHFX/AllTabs'))

'click accounts from "+" icon'
WebUI.click(findTestObject('HFX/SalesforseHFX/accounts'))

WebUI.click(findTestObject('HFX/SalesforseHFX/new'))

'verify account name search box'
WebUI.verifyElementPresent(findTestObject('HFX/SalesforseHFX/searchAccountNAme'), 5)

'add text to search parent account name available or not'
WebUI.setText(findTestObject('HFX/SalesforseHFX/searchAccountNAme'), parentacname)

WebUI.click(findTestObject('HFX/SalesforseHFX/searchButton2'))

//WebUI.click(findTestObject('HFX/SalesforseHFX/ParentAccount'))
'verify parent account aleady exist or not'
boolean parentAccountVisible = WebUI.verifyElementVisible(findTestObject('HFX/SalesforseHFX/ParentAccount'))

if (parentAccountVisible && WebUI.getText(findTestObject('HFX/SalesforseHFX/ParentAccount')).equals(parentacname)) {
    WebUI.click(findTestObject('HFX/SalesforseHFX/ParentAccount'))

    WebUI.delay(10)

    WebUI.setText(findTestObject('HFX/SalesforseHFX/childAcName'), childacname)
} else {
    WebUI.verifyElementVisible(findTestObject('HFX/SalesforseHFX/NoResult'))

    WebUI.click(findTestObject('HFX/SalesforseHFX/NewParentAc'))

    WebUI.delay(10)

    WebUI.setText(findTestObject('HFX/SalesforseHFX/SetPName'), parentacname)

    WebUI.setText(findTestObject('HFX/SalesforseHFX/childAcName'), childacname)
}

'add text in street field'
WebUI.setText(findTestObject('HFX/SalesforseHFX/Street'), street)

WebUI.setText(findTestObject('HFX/SalesforseHFX/Division'), division)

//WebUI.setText(findTestObject('HFX/SalesforseHFX/division'), division)
'add text in address3 field'
WebUI.setText(findTestObject('HFX/SalesforseHFX/Address3'), address)

WebUI.setText(findTestObject('HFX/SalesforseHFX/address4'), address2)

WebUI.setText(findTestObject('HFX/SalesforseHFX/PostalCode'), postalcode)

'add text in sub locality field'
WebUI.setText(findTestObject('HFX/SalesforseHFX/SubLocality'), sublocality)

'add text in city field'
WebUI.setText(findTestObject('HFX/SalesforseHFX/City'), city)

WebUI.click(findTestObject('HFX/SalesforseHFX/Country'))

WebUI.switchToWindowIndex(url)

WebUI.switchToFrame(findTestObject('HFX/SalesforseHFX/Iframes/frame_1'), 30)

'add text to search a country name in a popup window\r\n'
WebUI.setText(findTestObject('HFX/SalesforseHFX/lookup'), country)

WebUI.click(findTestObject('HFX/SalesforseHFX/Go'))

WebUI.switchToWindowIndex(url)

WebUI.switchToFrame(findTestObject('HFX/SalesforseHFX/Iframes/frame_2'), 30)

'select a country name from popup window'
WebUI.click(findTestObject('HFX/SalesforseHFX/LookupResult'))

WebUI.switchToWindowIndex(1)

'add text in state field'
WebUI.setText(findTestObject('HFX/SalesforseHFX/State'), state)

'click on the save button'
WebUI.click(findTestObject('HFX/SalesforseHFX/save'))

