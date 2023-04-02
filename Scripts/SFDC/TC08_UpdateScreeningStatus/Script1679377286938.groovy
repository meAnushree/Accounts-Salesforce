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

WebUI.callTestCase(findTestCase('SFDC/Common/TC_AccountPageSteps'), [('searchAccountName') : 'Test'], FailureHandling.STOP_ON_FAILURE)

'Click on the first search result after searching a text'
WebUI.click(findTestObject('SFDC/AccountPage/FirstSearchResult'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))

WebUI.comment('TC80, TC86.01')

String xpath = ((findTestObject('SFDC/EditPage/ChangeScreeningStatus').findPropertyValue('xpath') + '//option[@value=\'') + screeningStatus) + '\']'
println(xpath)
TestObject option = new TestObject('objectName')

option.addProperty('xpath', ConditionType.EQUALS, xpath)

WebUI.click(option)

WebUI.scrollToElement(findTestObject('SFDC/EditPage/ExportScreeningStatus'), GlobalVariable.delay)

'Click on Send to SAP checkbox'
WebUI.click(findTestObject('SFDC/EditPage/SendToSAP'))

WebUI.click(findTestObject('SFDC/EditPage/SaveButton(Edit)'))

WebUI.click(findTestObject('SFDC/EditPage/Edit'))


