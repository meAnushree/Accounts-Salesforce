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

WebUI.comment('TC105')

'This will navigate home page to profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on 2-5_Sales Operation Clone profile'
user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Sales Operations Clone', 'Type')

salesUser = findTestData('SFDC/Profiles').getValue('Profile', user)

'Login with `Eric Edlin` user'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : salesUser, ('username') : findTestObject(
            'SFDC/Profiles/EricEdlinUser')], FailureHandling.STOP_ON_FAILURE)

'This will navigate home page to account name search page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

'Click on parent account from the child account'
WebUI.click(findTestObject('SFDC/EditPage/ParentAccount(EditPage)'))

WebUI.comment('TC105.02')

'Add new contact'
WebUI.scrollToElement(findTestObject('SFDC/AdditionalInfo/NewContact'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/AdditionalInfo/NewContact'))

WebUI.setText(findTestObject('SFDC/AdditionalInfo/FirstName'), firstName)

WebUI.setText(findTestObject('SFDC/AdditionalInfo/LastName'), lastName)

WebUI.setText(findTestObject('SFDC/AdditionalInfo/Mobile'), mobile)

WebUI.setText(findTestObject('SFDC/AdditionalInfo/Phone'), mobile)

WebUI.setText(findTestObject('SFDC/AdditionalInfo/Street'), street)

WebUI.setText(findTestObject('SFDC/AdditionalInfo/City'), city)

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

WebUI.click(findTestObject('SFDC/CreateOpportunities/AccountName'))

'Get the index of the present window'
window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window + 1)

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('SFDC/EditPage/lookup'), accountName)

WebUI.click(findTestObject('SFDC/Navigation/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('SFDC/AccountPage/LookupResult'))

WebUI.switchToWindowIndex(window)

not_run: WebUI.click(findTestObject('SFDC/AdditionalInfo/CheckBox'))

WebUI.click(findTestObject('SFDC/AdditionalInfo/SaveBtn'))

WebUI.delay(GlobalVariable.delay)

WebUI.verifyElementVisible(findTestObject('SFDC/AdditionalInfo/VerifyContact'), FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC105.03')

'Add new case'
WebUI.scrollToElement(findTestObject('SFDC/AdditionalInfo/NewCase'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/AdditionalInfo/NewCase'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/ContinueBtn'))

WebUI.delay(GlobalVariable.delay)

'Verify that user can add a new case'
WebUI.verifyElementVisible(findTestObject('SFDC/AdditionalInfo/NewCasePage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AdditionalInfo/CancelBtn'))

WebUI.delay(GlobalVariable.delay)

'This will navigate home page to account name search page'
not_run: WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

'Click on parent account from the child account'
not_run: WebUI.click(findTestObject('SFDC/EditPage/ParentAccount(EditPage)'))

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

'Click on log out button '
WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

WebUI.comment('TC109')

'This will navigate to profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on 2-5_Sales Operation Clone profile'
profile = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'VPsClone', 'Type')

vpsUser = findTestData('SFDC/Profiles').getValue('Profile', profile)

'Login with `Liz Luu` user'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : vpsUser, ('username') : findTestObject(
            'SFDC/Profiles/LizLuuUser')], FailureHandling.STOP_ON_FAILURE)

'This will navigate home page to account name search page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

'Click on parent account from the child account'
WebUI.click(findTestObject('SFDC/EditPage/ParentAccount(EditPage)'))

WebUI.scrollToElement(findTestObject('SFDC/AdditionalInfo/NewAccountTeam'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/AdditionalInfo/NewAccountTeam'))

'Add text in user field in the new account team creation page'
WebUI.setText(findTestObject('SFDC/AdditionalInfo/TeamUserName'), teamUserName)

WebUI.click(findTestObject('SFDC/AdditionalInfo/TeamRole'))

WebUI.click(findTestObject('SFDC/AdditionalInfo/SaveBtn'))

WebUI.delay(GlobalVariable.delay)

'Click on parent account after creating a team'
WebUI.click(findTestObject('SFDC/AdditionalInfo/AccountTeamDetail'))

WebUI.scrollToElement(findTestObject('SFDC/AdditionalInfo/NewAccountTeam'), GlobalVariable.delay)

'Get text from source section in account team'
String source = WebUI.getText(findTestObject('SFDC/AdditionalInfo/Source'))

'Verify that account team source is manual'
WebUI.verifyEqual(source, teamSource)

