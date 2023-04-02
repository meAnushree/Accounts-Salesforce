package writeMEUData

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {


	@Keyword
	public void write(int rowNum,Object[] data) throws IOException{
		// Insert Data into existing excel file
		String filePath = System.getProperty('user.dir') + "\\Data Files\\WriteMEUData.xlsx"

		FileInputStream fileInput = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);

		fileInput.close()

		XSSFSheet sheet = workbook.getSheet("Sheet1");//get the excel sheet

		Row row = sheet.getRow(rowNum)
		int colCount = sheet.getRow(0).lastCellNum - sheet.getRow(0).firstCellNum
		println(colCount)
		println(data.length)

		for(int col = 1; col < colCount; col++) {
			println("F1")
			Cell cell = row.createCell(col)
			println("F2")
			cell.setCellValue(data[col-1])
			println("F3")
		}

		FileOutputStream fileOutput = new FileOutputStream(filePath);
		workbook.write(fileOutput);
		fileOutput.close();
		//fileOutput.flush()

	}
}