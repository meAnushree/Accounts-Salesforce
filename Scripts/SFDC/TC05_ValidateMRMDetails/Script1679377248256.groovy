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

WebUI.comment('TC46, TC48')

'Click on 2-5_Sales Operation Clone profile'
user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Sales Operations Clone', 'Type')

salesUser = findTestData('SFDC/Profiles').getValue('Profile', user)

'Login with Eric Edlin user'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : salesUser, ('username') : findTestObject(
			'SFDC/New Folder/EricEdlinUser')], FailureHandling.STOP_ON_FAILURE)

'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

'Click on parent account from the child account'
WebUI.click(findTestObject('SFDC/EditPage/ParentAccount(EditPage)'))

WebUI.scrollToElement(findTestObject('SFDC/EditPage/Edit'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.scrollToElement(findTestObject('SFDC/EditPage/LastMRMDate'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/EditPage/NextMRMDate'))

'Verify that calender is open after clicking on MRM field'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/NextMRMDate'))

WebUI.click(findTestObject('SFDC/EditPage/LastMRMDate'))

'Verify that calender is open after clicking on MRM field'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/MRMCalender'), FailureHandling.STOP_ON_FAILURE)

'Set a blank text to verify that it is not a required field'
WebUI.setText(findTestObject('SFDC/EditPage/LastMRMDate'), blank)

'Set a blank text to verify that it is not a required field'
WebUI.setText(findTestObject('SFDC/EditPage/NextMRMDate'), blank)

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

WebUI.delay(GlobalVariable.delay)

'Verify that account details succesfully saved'
WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/Edit'), FailureHandling.STOP_ON_FAILURE)

