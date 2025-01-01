package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String readStringData(int row, int col, String sheet) throws IOException {
		String path = Constant.TESTDATA;
		f = new FileInputStream(path);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String readIntegerCellValue(int row, int col, String sheet) throws IOException {
		String path = Constant.TESTDATA;
		f = new FileInputStream(path);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue();
		return String.valueOf(val);
	}

	public static String readStringDataFromNewSheet(int row, int col, String LoginTest1) throws IOException {
		String path = Constant.TESTDATA;
		f = new FileInputStream(path);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(LoginTest1);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}
}
