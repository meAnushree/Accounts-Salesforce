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

'This will navigate to profile page'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_ProfilePageSteps'), [:], FailureHandling.STOP_ON_FAILURE)

'Get value from excel file'
sales = CustomKeywords.'readDataFromDataFile.readData.search'('Data Files/SFDC/Profiles', 'Inside Sales', 'Type')

insideSales = findTestData('SFDC/Profiles').getValue('Profile', sales)

'Clicking on `2_1 Inside-Sales` profile'
WebUI.callTestCase(findTestCase('SFDC/Common/TC_Impersonation'), [('profileList') : insideSales], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('TC122')

WebUI.callTestCase(findTestCase('SFDC/TC_CreateAccount'), [('parentAccountName') : pAcName, ('childAccountName') : cAcName
        , ('street') : '', ('division') : '', ('address') : ''
        , ('address2') : '', ('postalcode') : '', ('sublocality') : ''
        , ('city') : '', ('country') : '', ('state') : ''], FailureHandling.STOP_ON_FAILURE)

