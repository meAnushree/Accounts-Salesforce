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

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC06')

'TC1 to TC5 scenarios repeat for two users'
for (String profile : profile_list) {
    String xpath = ((profile_name + '//span[text()=\'') + profile) + '\']'

    println(xpath)

    TestObject profile_item = new TestObject('objectName')

    profile_item.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(profile_item)

    WebUI.click(findTestObject('SFDC/ViewUsers'))

    WebUI.click(findTestObject('SFDC/LogInUser'))

    WebUI.callTestCase(findTestCase('SFDC/TC02_AccountsNameSearch'), [('AccPageMsg') : 'Search using the Account Name plus partial address(Street, City, Country name) to refine matching results'
            , ('SearchAcName') : 'test', ('SearchAcName2') : 'test 1', ('GarbageValue') : 'abcdefgh', ('SearchList') : [
                'test', 'test 1', 'abcdefghijkl']], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('SFDC/Dropdown'))

    WebUI.click(findTestObject('SFDC/LogOut'))

    'This will navigate home page from profile page'
    WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)
}

//WebUI.comment('TC10')
WebUI.comment('TC11')

'Clicking on profile 2_1 Inside-Sales'
WebUI.click(findTestObject('SFDC/InsideSales'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

WebUI.click(findTestObject('SFDC/LogInUser'))

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/NewParentAccount'))

'Set text in parent account field'
WebUI.setText(findTestObject('SFDC/PAccountName'), parentAccountName + new Random().nextInt(10000))

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

WebUI.click(findTestObject('SFDC/Dropdown'))

'Click on log out button '
WebUI.click(findTestObject('SFDC/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC12')

'Click on 3_1-Order fullfilment profile'
WebUI.click(findTestObject('SFDC/Profiles/3_1-OrderFullfilment'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

'Verify that user cannnot login to create a account'
WebUI.verifyElementNotPresent(findTestObject('SFDC/LogInUser'), GlobalVariable.delay)

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC13')

'Click on 3_5-Order Management profile'
WebUI.click(findTestObject('SFDC/Profiles/3_5-OrderManagement'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

'Login with the user (Leslie Padilla)'
WebUI.click(findTestObject('SFDC/LogInOm'))

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/Edit'))

WebUI.callTestCase(findTestCase('SFDC/TC_ValidatingAccountDetails'), [('Url') : 'https://cadence--hfx.sandbox.my.salesforce.com/_ui/common/data/LookupPage?lkfm=editPage&lknm=CF00Nd00000056FdB&lktp=a0H&lksrch=100'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/Dropdown'))

'Click on log out button '
WebUI.click(findTestObject('SFDC/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC14.01')

for (String profile : profile_list2) {
    String xpath = ((profile_name + '//span[text()=\'') + profile) + '\']'

    println(xpath)

    TestObject profile_item = new TestObject('objectName')

    profile_item.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(profile_item)

    WebUI.click(findTestObject('SFDC/ViewUsers'))

    WebUI.click(findTestObject('SFDC/LogInUser'))

    'This will navigate from home page to accounts name search page and search a text'
    WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on the first search result after searching a text'
    WebUI.click(findTestObject('SFDC/FirstSearchResult'))

    WebUI.click(findTestObject('SFDC/Edit'))

    if (WebUI.verifyElementVisible(findTestObject('SFDC/eDAoTIndex'), FailureHandling.OPTIONAL)) {
        'Get the text from input box'
        String eDAoT = WebUI.getAttribute(findTestObject('SFDC/eDAoTIndex'), 'value')

        println(eDAoT)

        WebUI.setText(findTestObject('SFDC/ChangeCAcName'), eDAoT)
    } else {
        WebUI.setText(findTestObject('SFDC/ChangeCAcName'), changeAccountName)
    }
    
    WebUI.click(findTestObject('SFDC/SaveButton(Edit)'))

    'Verify the page is coming after the edit page is saved'
    WebUI.verifyElementPresent(findTestObject('SFDC/VerifyEditPage'), GlobalVariable.delay)

    WebUI.click(findTestObject('SFDC/Dropdown'))

    WebUI.click(findTestObject('SFDC/LogOut'))

    'This will navigate home page from profile page'
    WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.comment('TC14.02')

'Click on 3_1-Order fullfilment profile'
WebUI.click(findTestObject('SFDC/3_1-OrderFullfilment'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

'Verify that user cannot login to create a account'
WebUI.verifyElementNotPresent(findTestObject('SFDC/LogInUser'), GlobalVariable.delay)

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC15.02')

WebUI.click(findTestObject('SFDC/Profiles/2_2-AX'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

WebUI.click(findTestObject('SFDC/LogInUser'))

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/Edit'))

'Verify that after clicking on edit button, there is an error page visible'
WebUI.verifyElementPresent(findTestObject('SFDC/InsufficientPrivileges'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Dropdown'))

WebUI.click(findTestObject('SFDC/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'sfdc.AccountPage.accPage'()
'This will navigate from home page to accounts name search page and search a text'
WebUI.comment('TC16.01')

for (String profile : profile_list3) {
    String xpath = ((profile_name + '//span[text()=\'') + profile) + '\']'

    println(xpath)

    TestObject profile_item = new TestObject('objectName')

    profile_item.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(profile_item)

    WebUI.click(findTestObject('SFDC/ViewUsers'))

    WebUI.click(findTestObject('SFDC/LogInUser'))

    'This will navigate from home page to accounts name search page and search a text'
    WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on the first search result after searching a text'
    WebUI.click(findTestObject('SFDC/FirstSearchResult'))

    WebUI.click(findTestObject('SFDC/Edit'))

    'Check that customer name present or not'
    if (WebUI.verifyElementVisible(findTestObject('SFDC/CustomerName'), FailureHandling.OPTIONAL)) {
        'Get the text from input box'
        String customerName = WebUI.getAttribute(findTestObject('SFDC/CustomerName'), 'value')

        println(customerName)

        WebUI.setText(findTestObject('SFDC/CustomerName'), customerName)
    } else {
        WebUI.setText(findTestObject('SFDC/CustomerName'), changeAccountName)
    }
    
    WebUI.click(findTestObject('SFDC/SaveButton(Edit)'))

    'Verify the page is coming after the edit page is saved'
    WebUI.verifyElementPresent(findTestObject('SFDC/VerifyEditPage'), GlobalVariable.delay)

    WebUI.click(findTestObject('SFDC/Dropdown'))

    WebUI.click(findTestObject('SFDC/LogOut'))

    'This will navigate home page from profile page'
    WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.comment('TC17.01')

WebUI.click(findTestObject('SFDC/Profiles/2_2-AX'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

WebUI.click(findTestObject('SFDC/LogInUser'))

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/Edit'))

'Verify that after clicking on edit button, there is an error page visible'
WebUI.verifyElementPresent(findTestObject('SFDC/InsufficientPrivileges'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Dropdown'))

WebUI.click(findTestObject('SFDC/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC18.01')

'Click on 2_5-SalesOp profile'
WebUI.click(findTestObject('SFDC/Profiles/2_5-SalesOp'))

WebUI.click(findTestObject('SFDC/ViewUsers'))

WebUI.click(findTestObject('SFDC/LogInUser'))

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/Edit'))

'Chcek that SFDC Status present of not'
if (WebUI.verifyElementVisible(findTestObject('SFDC/SFDCStatus'), FailureHandling.OPTIONAL)) {
    'Make the SFDC Status inactive '
    WebUI.click(findTestObject('SFDC/ChangeSFDCStatus'))
}

WebUI.comment('TC19.01')

'Check that sold to field already checked'
WebUI.verifyElementVisible(findTestObject('SFDC/SoldTo'), FailureHandling.OPTIONAL)

'Check that ship/install field already checked'
WebUI.verifyElementVisible(findTestObject('SFDC/ShipInstall'), FailureHandling.OPTIONAL)

'Check that bill/player field already checked'
WebUI.verifyElementVisible(findTestObject('SFDC/BillPlayer'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SFDC/SaveButton(Edit)'))

'Verify that after editing the page will successfully saved'
WebUI.verifyElementPresent(findTestObject('SFDC/VerifyEditPage'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Dropdown'))

WebUI.click(findTestObject('SFDC/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC20')

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/Edit'))

WebUI.click(findTestObject('SFDC/SoldTo(CosData)'))

'Verify that after unchecking that sold to field and error comes up'
WebUI.verifyElementPresent(findTestObject('SFDC/SoldToError'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/CancelButton'))

//WebUI.comment('TC22')
//
//WebUI.click(findTestObject('SFDC/Edit'))
//
//'Get the value from account name input field'
//String childAccoutName = WebUI.getAttribute(findTestObject('SFDC/changeCAcName'), 'value')
//
//println(childAccoutName)
//
//'Text added in sold to account field'
//WebUI.setText(findTestObject('SFDC/AccountsNameSearch'), childAccoutName)
//
//'Verify that sold to account gives an error'
//WebUI.verifyElementPresent(findTestObject('SFDC/SoldToError'), GlobalVariable.delay)




//WebUI.comment('TC28')
//
//WebUI.click(findTestObject('SFDC/Edit'))
//
//'Clicking on send to sap checkbox'
//WebUI.click(findTestObject('SFDC/SendToSAP'))




//WebUI.comment('TC29')
//
//'Click on 3_5-Order Management profile'
//WebUI.click(findTestObject('SFDC/Profiles/3_5-OrderManagement'))
//
//WebUI.click(findTestObject('SFDC/ViewUsers'))
//
//'Login with the user (Leslie Padilla)'
//WebUI.click(findTestObject('SFDC/LogInOm'))
//
//'This will navigate from home page to accounts name search page and search a text'
//WebUI.callTestCase(findTestCase('SFDC/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.click(findTestObject('SFDC/InactiveAccount'))

