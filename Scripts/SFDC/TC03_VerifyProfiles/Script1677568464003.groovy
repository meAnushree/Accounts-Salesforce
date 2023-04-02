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

WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC11')

'Get value from excel file'
sales = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Inside Sales', 'Type')

insideSales = findTestData('SFDC/Profiles').getValue('Profile', sales)

'Clicking on profile 2_1 Inside-Sales'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : insideSales], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/NewParentAccount'))

'This will generate a random string'
accountName = CustomKeywords.'randomStringGenerate.StringGenerate.randomString'(4)

'Set text in parent account field'
WebUI.setText(findTestObject('SFDC/AccountPage/PAccountName'), parentAccountName + accountName)

'Creating a random child account name and set the text in child account field in account creation page'
WebUI.setText(findTestObject('SFDC/AccountPage/ChildAcName'), childAccountName + accountName)

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

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

'Click on log out button '
WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC12')

'Click on 3_1-Order fullfilment profile'
managerClone = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Order Fulfillment', 'Type')

orderFulfillment = findTestData('SFDC/Profiles').getValue('Profile', managerClone)

WebUI.click(findTestObject('SFDC/Profiles/OrderFullfilmentProfile', [('name') : orderFulfillment]))

WebUI.click(findTestObject('SFDC/Navigation/ViewUsers'))

'Verify that user cannnot login to create a account'
WebUI.verifyElementNotPresent(findTestObject('SFDC/Navigation/LogInUser'), GlobalVariable.delay)

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC13')

'Click on 3_5-Order Management profile'
management = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Order Management', 'Type')

orderManagement = findTestData('SFDC/Profiles').getValue('Profile', management)

WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : orderManagement], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.callTestCase(findTestCase('SFDC/TC_ValidatingAccountDetails'), [('customerName') : 'Bruse Test', ('salesOrganization') : '1000'
        , ('deliveringPlant') : '2000', ('languageCode') : 'A', ('searchTerm') : 'Dans LDP', ('companyCode') : '100'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

'Click on log out button '
WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC15, TC17')

'Click on 2_2-AX profile'
ax = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'AX', 'Type')

salesAX = findTestData('SFDC/Profiles').getValue('Profile', ax)

WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : salesAX], FailureHandling.STOP_ON_FAILURE)


'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Verify that after clicking on edit button, there is an error page visible'
WebUI.verifyElementPresent(findTestObject('SFDC/ErrorMsg/InsufficientPrivileges'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC18.01')

'Click on 2_5-SalesOp profile'
salesOp = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Sales Operations Clone', 'Type')

salesOperation = findTestData('SFDC/Profiles').getValue('Profile', salesOp)

WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : salesOperation], FailureHandling.STOP_ON_FAILURE)


'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

'Chcek that SFDC Status present of not'
if (WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/SFDCStatus'), FailureHandling.OPTIONAL)) {
    'Make the SFDC Status inactive '
    WebUI.click(findTestObject('SFDC/EditPage/ChangeSFDCStatus'))
}

WebUI.comment('TC19.01')

'Check that sold to field already checked'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/SoldTo'), FailureHandling.OPTIONAL)

'Check that ship/install field already checked'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/ShipInstall'), FailureHandling.OPTIONAL)

'Check that bill/player field already checked'
WebUI.verifyElementVisible(findTestObject('SFDC/BillPlayer'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

'Verify that after editing the page will successfully saved'
WebUI.verifyElementPresent(findTestObject('SFDC/EditPage/VerifyEditPage'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC20')

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.click(findTestObject('SFDC/EditPage/SoldTo(CosData)'))

'Verify that after unchecking that sold to field and error comes up'
WebUI.verifyElementPresent(findTestObject('SFDC/EditPage/SoldToError'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/AccountPage/CancelButton'))

