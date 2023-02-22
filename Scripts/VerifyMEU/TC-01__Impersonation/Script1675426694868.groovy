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
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.CellStyle as CellStyle
import org.apache.poi.ss.usermodel.Font as Font
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('AccountCreation/TC-01__LogInPage'), [('Url') : 'https://cadence.oktapreview.com/', ('Username') : 'internalcossupportadmin@cadence.com'
        , ('Password') : 'Cdns1234'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SBX/UserDropdown'))

WebUI.click(findTestObject('SBX/SetUp'))

WebUI.click(findTestObject('SBX/ManageUsers'))

WebUI.click(findTestObject('SBX/Profile'))

List listofelements = WebUI.findWebElements(findTestObject('SBX/AllProfiles'), GlobalVariable.delay)

int length = listofelements.size()

println(length)

// Create a new Empty Excel file
//XSSFWorkbook workbook = new XSSFWorkbook()//creating empty workbook
//
//XSSFSheet sheet = workbook.createSheet('Sheet1')//create empty sheet
//
//Row row = sheet.createRow(0)//create row in excel sheet
//
//CellStyle style = workbook.createCellStyle()//for styling
//
//Font font = workbook.createFont()//for font
//font.setBold(true)
//style.setFont(font)
//
////cell creation
//Cell c0 = row.createCell(0)
//Cell c1 = row.createCell(1)
//Cell c2 = row.createCell(2)
//
////apply styling
//c0.setCellStyle(style)
//c1.setCellStyle(style)
//c2.setCellStyle(style)
//
////set cell value
//c0.setCellValue('User')
//c1.setCellValue('Visible')
//c2.setCellValue('Editable')
//
//FileOutputStream fileOutput = new FileOutputStream(System.getProperty('user.dir') + '\\Test data\\WriteSBX.xlsx')
//
//workbook.write(fileOutput)//write in output file
//
//fileOutput.close()
////excel file creation finished
int row = 1

for (String profile : profile_list) {
	println(profile)
    String xpath = ((profile_name + '//span[text()=\'') + profile) + '\']'

    println(xpath)

    TestObject profile_item = new TestObject('objectName')

    profile_item.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(profile_item)

    def userData = WebUI.callTestCase(findTestCase('VerifyMEU/TC-02__VerifyMEU'), [('search') : 'Cutover2013'])

    println(userData)

    CustomKeywords.'writeMEUData.WriteExcel.write'(row, userData)

    row++
}

