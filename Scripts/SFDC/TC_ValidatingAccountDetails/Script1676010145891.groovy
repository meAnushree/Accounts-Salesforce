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

'Click on currency option'
    WebUI.click(findTestObject('SFDC/CurrencyOption'),FailureHandling.OPTIONAL)


 'Text added in customer name'
	WebUI.setText(findTestObject('SFDC/CustomerName'), customerName,FailureHandling.OPTIONAL)


 'Text added in sales organisation'
	WebUI.setText(findTestObject('SFDC/SalesOrganization'), salesOrganization,FailureHandling.OPTIONAL)


 'Text added in delivering plant'

	WebUI.setText(findTestObject('SFDC/DeliveringPlant'), deliveringPlant,FailureHandling.OPTIONAL)

	'Text added in language code'
	WebUI.setText(findTestObject('SFDC/LanguageCode'), languageCode,FailureHandling.OPTIONAL)

	'Text added in search term'
	WebUI.setText(findTestObject('SFDC/SearchTerm'), searchTerm,FailureHandling.OPTIONAL)


 'Change company code value'
	WebUI.click(findTestObject('SFDC/CompanyCodeLookup'),FailureHandling.OPTIONAL)
	int window = WebUI.getWindowIndex()
	WebUI.switchToWindowIndex(window +1)
	WebUI.setText(findTestObject('SFDC/lookup'), companyCode)
	WebUI.click(findTestObject('SFDC/GoButton'))
	WebUI.click(findTestObject('SFDC/LookupResult'))
	WebUI.switchToWindowIndex(window - 1)


'Clicking on cancel button'
WebUI.click(findTestObject('SFDC/CancelButton'))










