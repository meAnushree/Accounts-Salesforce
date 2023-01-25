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
import com.kms.katalon.core.testobject.ConditionType


'Installation Page\r\n'
WebUI.click(findTestObject('Cos/verifyEvePage/installation'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.back()

'Product Manuals Page\r\n'
WebUI.click(findTestObject('Cos/verifyEvePage/productManuals'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.back()

'Training Courses Page'
WebUI.click(findTestObject('Cos/verifyEvePage/TrainingCourses'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.back()

'What\'s New Page'
WebUI.click(findTestObject('Cos/verifyEvePage/WhatsNew'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.back()

'TRoubleshooting page\r\n'
WebUI.click(findTestObject('Cos/verifyEvePage/Troubleshooting'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.back()

'Video Library Page'
WebUI.click(findTestObject('Cos/verifyEvePage/videoLibrary'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.back()

'verify checkbox is not present in home page'
WebUI.verifyElementNotPresent(findTestObject('Cos/verifyEvePage/wildCardCheck'), GlobalVariable.delay)

WebUI.click(findTestObject('Cos/verifyEvePage/TrainingCourses'))

WebUI.click(findTestObject('Cos/verifyEvePage/wildCardCheck'))

WebUI.click(findTestObject('Cos/verifyEvePage/SearchBox'))

WebUI.setText(findTestObject('Cos/verifyEvePage/SearchBox'), search)

WebUI.click(findTestObject('Cos/verifyEvePage/Glass'))

WebUI.delay(GlobalVariable.delay)


'Verify highlighted text'
List listofelements  =  WebUI.findWebElements(findTestObject("Cos/verifyEvePage/SearchResults"), GlobalVariable.delay)
int length = listofelements.size()		
	println(length)
for (int i = 1; i <= length; i++) {
    String index = Integer.toString(i)
    String xpath = "(//div[@class='CoveoResultList']//span[@class='coveo-highlight'])[" + index + "]"
    TestObject object = new TestObject('objectName')
    object.addProperty('xpath', ConditionType.EQUALS, xpath)
    String data = WebUI.getText(object)
    println(search.toString())
	WebUI.verifyMatch(data.toLowerCase(),search.toString().replace('?','(.)'),  true) 
	
//    else (data.contains('?')) {
//        WebUI.click(findTestObject('SearchResults'), FailureHandling.STOP_ON_FAILURE)
//    }
}

'Verify checkbox remains chceked even after performing the search\r\n'
WebUI.verifyElementPresent(findTestObject('Cos/verifyEvePage/checked'), GlobalVariable.delay)

