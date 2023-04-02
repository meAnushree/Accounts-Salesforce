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

WebUI.comment('TC14.01')

if (condition.contains('Yes')) {
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : profile], FailureHandling.STOP_ON_FAILURE)


'This will navigate from home page to accounts name search page and search a text'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

if (WebUI.verifyElementVisible(findTestObject('SFDC/EditPage/eDAoTIndex'), FailureHandling.OPTIONAL)) {
	'Get the text from input box'
	String eDAoT = WebUI.getAttribute(findTestObject('SFDC/EditPage/eDAoTIndex'), 'value')

	println(eDAoT)

	WebUI.setText(findTestObject('SFDC/EditPage/ChangeCAcName'), eDAoT)
} else {
	WebUI.setText(findTestObject('SFDC/EditPage/ChangeCAcName'), changeAccountName)
}

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

'Verify the page is coming after the edit page is saved'
WebUI.verifyElementPresent(findTestObject('SFDC/EditPage/VerifyEditPage'), GlobalVariable.delay)

WebUI.click(findTestObject('SFDC/Navigation/Dropdown'))

WebUI.click(findTestObject('SFDC/Navigation/LogOut'))

'This will navigate home page from profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

}
else if(condition.contains('No')) {
	WebUI.comment('TC14.02, TC47')
	
	user = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', condition, 'Condition')
	
	orderFulfillment = findTestData('SFDC/Profiles').getValue('Profile', user)
	
	WebUI.click(findTestObject('SFDC/Profiles/OrderFullfilmentProfile', [('name') : orderFulfillment]))
	
	WebUI.click(findTestObject('SFDC/Navigation/ViewUsers'))
	
	'Verify that user cannot login to create a account'
	WebUI.verifyElementNotPresent(findTestObject('SFDC/Navigation/LogInUser'), GlobalVariable.delay)
	
	'This will navigate home page from profile page'
	WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)
	
}




