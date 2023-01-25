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

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/MyInfo'))

//first name//
//WebUI.click(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpFirstName'))
WebUI.doubleClick(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpFirstName'))

//WebUI.setText(findTestObject('null'),"")
WebUI.sendKeys(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpFirstName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpFirstName'), firstname)

//middle name//
//WebUI.click(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpMiddleName'))
WebUI.doubleClick(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpMiddleName'))

WebUI.sendKeys(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpMiddleName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpMiddleName'), middlename)

//last name//
WebUI.click(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpLastName'))

WebUI.doubleClick(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpLastName'))

WebUI.sendKeys(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpLastName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/EmpFullName/EmpLastName'), lastname)

//nickname//
WebUI.doubleClick(findTestObject('OrangeHRM/MyInfoPage/Nickname'))

WebUI.sendKeys(findTestObject('OrangeHRM/MyInfoPage/Nickname'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/Nickname'), nickname)

//empid//
WebUI.doubleClick(findTestObject('OrangeHRM/MyInfoPage/EmpId'))

WebUI.sendKeys(findTestObject('OrangeHRM/MyInfoPage/EmpId'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/EmpId'), empid)

//other id//
WebUI.doubleClick(findTestObject('OrangeHRM/MyInfoPage/OtherId'))

WebUI.sendKeys(findTestObject('OrangeHRM/MyInfoPage/OtherId'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/OtherId'), otherid)

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/LicenseEXPDate'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/ClearCal'))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/LicenseEXPDate'), licenseexpdate)

//WebUI.click(findTestObject('OrangeHRM/MyInfoPage/CloseCalender'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/Nationality'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/selectNationality'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/MaritalStatus'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/SelectMaritalStatus'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/DOB'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/ClearDOB'))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/DOB'), dob)

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/Gender'))

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/Military Service'))

WebUI.setText(findTestObject('OrangeHRM/MyInfoPage/Military Service'), militaryservice)

WebUI.click(findTestObject('OrangeHRM/MyInfoPage/Save'))

