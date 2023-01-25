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

WebUI.click(findTestObject('Cos/HomePage/SelectAll'))

'verify dropdown element "All"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/All'), GlobalVariable.delay)

'verify dropdown element "All Content"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/AllContent'), GlobalVariable.delay)

//WebUI.delay(GlobalVariable.delay)
'verify dropdown element "Product Manuals"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/ProductManuals'), GlobalVariable.delay)

'verify dropdown element "Articles and App"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/ArticlesAndApp'), GlobalVariable.delay)

'verify dropdown element "Training Courses"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/TrainingCourses'), GlobalVariable.delay)

'verify dropdown element "Community"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/Community'), GlobalVariable.delay)

'verify dropdown element "Cases"'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/Cases'), GlobalVariable.delay)

'verify SearchBox '
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/SearchBox'), GlobalVariable.delay)

WebUI.click(findTestObject('Cos/HomePage/SelectAll'))

//WebUI.click(findTestObject('Cos/HomePage/AllContent'))
WebUI.setText(findTestObject('Cos/HomePage/SearchBox'), search)

WebUI.verifyElementPresent(findTestObject('Cos/HomePage/Magnifying'), 0)

//WebUI.verifyElementPresent(findTestObject('Cos/HomePage/Magnifying'), GlobalVariable.delay)
WebUI.click(findTestObject('Cos/HomePage/Magnifying'))

WebUI.delay(GlobalVariable.delay)

//WebUI.click(findTestObject('Cos/HomePage/ShowAllAttribute'))
WebUI.click(findTestObject('Cos/HomePage/ShowAllAttribute'), FailureHandling.STOP_ON_FAILURE)

'verify search results attribute'
CustomKeywords.'cos.VerifyDocumentType.verify'(findTestObject('Cos/HomePage/Modus'))

WebUI.delay(GlobalVariable.delay)

WebUI.back()

//WebUI.back()
WebUI.click(findTestObject('Cos/HomePage/Magnifying'))

'verify dialog box'
WebUI.verifyElementPresent(findTestObject('Cos/HomePage/DialogBox'), GlobalVariable.delay)

WebUI.click(findTestObject('Cos/HomePage/CloseButton'))

'verify dialog box'
WebUI.verifyElementNotVisible(findTestObject('Cos/HomePage/DialogBox'), FailureHandling.STOP_ON_FAILURE)

