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

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC16.01')

WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : profileList], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Check that customer name present or not'
if (WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/CustomerName'), FailureHandling.OPTIONAL)) {
    'Get the text from input box'
    String customerName = WebUI.getAttribute(findTestObject('SFDC/EditPage/CustomerName'), 'value')

    println(customerName)

    WebUI.setText(findTestObject('SFDC/EditPage/CustomerName'), customerName)
} else {
    WebUI.setText(findTestObject('SFDC/EditPage/CustomerName'), changeAccountName)
}

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

'Verify the page is coming after the edit page is saved'
WebUI.verifyElementPresent(findTestObject('SFDC/EditPage/VerifyEditPage'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC31, TC33')

'Click on 3_5-Order Management profile'
management = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Order Management', 'Type')

orderManagement = findTestData('SFDC/Profiles').getValue('Profile', management)

WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : orderManagement], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify that all the child account visible along with parent account'
WebUI.verifyElementVisible(findTestObject('SFDC/AccountPage/AllSearchResults'), FailureHandling.OPTIONAL)

'Click on parent account from  search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/ParentAccountLink'))

'Creating a random child account name and set the text in child account field in account creation page\r\n'
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

WebUI.switchToWindowIndex(window - 1)

'Click on the save button'
WebUI.click(findTestObject('SFDC/AccountPage/Save'))

WebUI.delay(GlobalVariable.delay)

'Verify the result page after clicking the save button'
WebUI.click(findTestObject('SFDC/EditPage/VerifySavePage'))

WebUI.comment('TC32, TC34')

'Click on edit button'
WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Click on sold to check box'
WebUI.click(findTestObject('SFDC/EditPage/SoldTo(CosData)'))

'Verifying export screening status should be Unverified'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/ScreeningStatus'), FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('SFDC/TC_ValidatingAccountDetails'), [('customerName') : 'Bruse Test', ('salesOrganization') : '1000'
        , ('deliveringPlant') : '2000', ('languageCode') : 'A', ('searchTerm') : 'Dans LDP', ('companyCode') : '100'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.setText(findTestObject('SFDC/EditPage/City'), city, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('SFDC/EditPage/StateRegion'), state, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('SFDC/EditPage/PostalCode'), postalCode, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('SFDC/EditPage/Address3'), address, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SFDC/EditPage/SendToSAP'), FailureHandling.OPTIONAL)

'Verifying SAP status should be Active'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/SAPStatus'), FailureHandling.OPTIONAL)

'Verifying SAP response should be Ok'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/SAPResponse'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SFDC/AccountPage/CancelButton'))

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)


