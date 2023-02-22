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

WebUI.click(findTestObject('HFX/SalesforseHFX/Home'))

println(search)

'set text in the serach box to search a user\r\n'
WebUI.setText(findTestObject('HFX/SalesforseHFX/SearchBox'), search)

WebUI.click(findTestObject('HFX/SalesforseHFX/SearchButton'))

WebUI.delay(GlobalVariable.delay)

'click on a people from the search results'
WebUI.click(findTestObject('HFX/SalesforseHFX/People'))

'click user action menu'
WebUI.click(findTestObject('HFX/SalesforseHFX/UserActionMenu'))

'choose user details from user action menu\r\n'
WebUI.click(findTestObject('HFX/SalesforseHFX/UserDetails'))

'click on log in button'
WebUI.click(findTestObject('HFX/SalesforseHFX/userLogIn'))

