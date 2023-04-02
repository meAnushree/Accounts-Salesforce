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

'This will navigate to profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : profileList], FailureHandling.STOP_ON_FAILURE)

'TC1 to TC5 scenarios repeat for two users'
WebUI.comment('TC01')

'Click on "+" icon'
WebUI.click(findTestObject('SFDC/Navigation/AllTab'))

WebUI.click(findTestObject('SFDC/Navigation/Accounts'))

WebUI.click(findTestObject('SFDC/Navigation/NewButton'))

'Verifying account name search box is present'
WebUI.verifyElementVisible(findTestObject('SFDC/Navigation/AccountsNameSearch'), FailureHandling.STOP_ON_FAILURE)

'Verifying search button in lookup page is present'
WebUI.verifyElementVisible(findTestObject('SFDC/Navigation/LookUpSearchButton'), FailureHandling.STOP_ON_FAILURE)

'Get value from excel file'
message = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/AllMessages', 'Look Up', 'Condition')

searchBoxMsg = findTestData('SFDC/AllMessages').getValue('Message', message)

'Verify that Lookup message is visible in account name search page'
WebUI.verifyElementText(findTestObject('SFDC/ErrorMsg/LookUpMsg'), searchBoxMsg)

WebUI.comment('TC2')

'Single keyword text added in search box'
WebUI.setText(findTestObject('SFDC/Navigation/AccountsNameSearch'), searchAcName)

WebUI.click(findTestObject('SFDC/Navigation/LookUpSearchButton'))

WebUI.click(findTestObject('SFDC/AccountPage/ParentAccountLink'))

'Verify that create account open after clicking on Parent account link'
WebUI.verifyElementVisible(findTestObject('SFDC/AccountPage/CreateAccountPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/AccountPageCancelbtn'))

WebUI.click(findTestObject('SFDC/Navigation/NewButton'))

WebUI.comment('TC03')

'Multiple keyword text added in search box '
WebUI.setText(findTestObject('SFDC/Navigation/AccountsNameSearch'), searchAcName2)

WebUI.click(findTestObject('SFDC/Navigation/LookUpSearchButton'))

WebUI.comment('TC04')

'Random text added in search box'
WebUI.setText(findTestObject('SFDC/Navigation/AccountsNameSearch'), garbageValue)

WebUI.click(findTestObject('SFDC/Navigation/LookUpSearchButton'))

'Get value from excel file'
randomValue = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/AllMessages', 'Garbage Value', 'Condition')

noRecordsFound = findTestData('SFDC/AllMessages').getValue('Message', randomValue)

'Verify no records found text visible after searching random text'
WebUI.verifyElementText(findTestObject('SFDC/AccountPage/NoRecFound'), noRecordsFound)

WebUI.comment('TC5')

'Multiple keyword ext added in search box '
WebUI.setText(findTestObject('SFDC/Navigation/AccountsNameSearch'), searchAcName2)

WebUI.click(findTestObject('SFDC/Navigation/LookUpSearchButton'))

'Verify that after searching, search results along with three messages is visible'
WebUI.verifyElementVisible(findTestObject('SFDC/ErrorMsg/ThreeMsg'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/NewParentAccount'))

'Verify that after clicking on new parent account, account creation page is open'
WebUI.verifyElementVisible(findTestObject('SFDC/AccountPage/CreateAccountPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/AccountPageCancelbtn'))

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)



