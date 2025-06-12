package GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	public String readPropData(String path, String key) throws Throwable
    {
      FileInputStream fis=new FileInputStream(path);
      Properties prop = new Properties();
      prop.load(fis);
      String propValue = prop.getProperty(key, "Incorrect Key");
      return propValue;
    }
	public String readExcelData(String path, String sheetName, int row, int cellNum) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheetName).getRow(row).getCell(cellNum).toString();	
		return excelValue;
		
	}
	
	public void writeExcelData(String path, String sheetName, int row, int cellNum, String data) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
	}
	

}
