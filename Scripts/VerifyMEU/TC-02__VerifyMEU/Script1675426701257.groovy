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

WebUI.click(findTestObject('SBX/ViewUsers'))

WebUI.click(findTestObject('SBX/NameOfUser'))

String name = WebUI.getText(findTestObject('SBX/User'))

println(name)

//Login process
WebUI.click(findTestObject('SBX/LogInUser'))

WebUI.click(findTestObject('HFX/SalesforseHFX/AllTabs'))

WebUI.click(findTestObject('HFX/SalesforseHFX/accounts'))

WebUI.setText(findTestObject('SBX/SearchBox'), Search)

WebUI.click(findTestObject('SBX/SearchButton'))

WebUI.click(findTestObject('SBX/ChildAccount'))

'Verify Military End User field visible or not'
visible = WebUI.verifyElementVisible(findTestObject('SBX/MEU'), FailureHandling.OPTIONAL)

println(visible)

editable = false

//check Edit button is avaible after verifying the MEU field
if (visible) {
    WebUI.click(findTestObject('SBX/Edit'))

    editable = WebUI.verifyElementClickable(findTestObject('SBX/MEU'), FailureHandling.CONTINUE_ON_FAILURE)

    println(editable)

    WebUI.click(findTestObject('SBX/Cancel'))
}

//LogOut and back to profile page
WebUI.click(findTestObject('SBX/Dropdown'))

WebUI.click(findTestObject('SBX/LogOut'))

WebUI.click(findTestObject('SBX/UserDropdown'))

WebUI.click(findTestObject('SBX/SetUp'))

WebUI.click(findTestObject('SBX/ManageUsers'))

WebUI.click(findTestObject('SBX/Profile'))
Object[] rData = new Object[3]
rData[0] = name
rData[1] = visible
rData[2] = editable
println(rData)
return rData



