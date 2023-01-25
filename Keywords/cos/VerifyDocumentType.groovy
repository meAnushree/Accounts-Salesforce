package cos

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement

import internal.GlobalVariable

public class VerifyDocumentType {
	@Keyword
	def verify(TestObject Modus) {
		List<WebElement> docs = WebUI.findWebElements(Modus,10)
		int length = docs.size()
		println(Modus)
		println(length)

		for( int i= 1 ; i<=length;i++) {
			String index = Integer.toString(i)
			String xpath = '(//div[@class="coveo-result-frame "]//tr[@data-caption="Document Type:"]//span[text()="Product Manuals"])' + "[" + index + "]"
			println(xpath)
			TestObject to = new TestObject("objectName")
			to.addProperty("xpath", ConditionType.EQUALS, xpath)
			WebUI.verifyElementPresent(to, 10)
		}
		println("Document Type Verified")
	}
}
