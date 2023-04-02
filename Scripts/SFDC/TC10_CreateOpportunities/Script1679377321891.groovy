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

WebUI.comment('TC103, TC104')

'Click on "+" icon'
WebUI.click(findTestObject('SFDC/Navigation/AllTab'))

'Click on opportunities tab'
WebUI.click(findTestObject('SFDC/CreateOpportunities/Opportunities'))

'Click on new button'
WebUI.click(findTestObject('SFDC/Navigation/NewButton'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/ContinueBtn'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/AccountName'))

'Get the index of the present window'
int window = WebUI.getWindowIndex()

'Switch the window '
WebUI.switchToWindowIndex(window = (window + 1))

'Add text to search a country name in a popup window'
WebUI.setText(findTestObject('SFDC/EditPage/lookup'), accountName)

WebUI.click(findTestObject('SFDC/Navigation/GoButton'))

'Select a country name from popup window'
WebUI.click(findTestObject('SFDC/AccountPage/LookupResult'))

WebUI.switchToWindowIndex(window = (window - 1))

WebUI.setText(findTestObject('SFDC/CreateOpportunities/TCV(USD)'), tcv)

WebUI.setText(findTestObject('SFDC/CreateOpportunities/Term(Month)'), term)

WebUI.setText(findTestObject('SFDC/CreateOpportunities/ProposedDiscount'), proposedDiscount)

WebUI.setText(findTestObject('SFDC/CreateOpportunities/DefaultDiscount'), defaultDiscount)

WebUI.click(findTestObject('SFDC/CreateOpportunities/LineLevelDiscount'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/Region'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/TransactionType'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/DealReview'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/MEU'))

WebUI.click(findTestObject('SFDC/CreateOpportunities/SaveBtn'))

WebUI.delay(GlobalVariable.delay)

'Verify that after entering all the required field values, page will save without any error'
WebUI.verifyElementVisible(findTestObject('SFDC/CreateOpportunities/SavePage'), FailureHandling.STOP_ON_FAILURE)

