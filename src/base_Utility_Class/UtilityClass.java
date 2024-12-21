package base_Utility_Class;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	//This method is use to get data from excel sheet
	//need to pass 2 inputs 1:RowIndex 2:CellIndex
	//@Auther Name:Sima
public static String SheetData (int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
{
	FileInputStream File = new FileInputStream("D:\\Software Testing\\Automation\\Username Password.xlsx");
	 Sheet Sheet = WorkbookFactory.create(File).getSheet("Sheet1");	
	 String Value = Sheet.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
	 return Value;
}

public static void Screenshot (WebDriver driver, int TCID) throws IOException
{
File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File Dest = new File("C:\\Users\\Dell\\eclipse-workspace\\Test_NG4\\Failed_Screenshots\\TCID"+TCID+".jpg");
FileHandler.copy(Source, Dest);
}

public static String Properties (String Key) throws IOException
{
	FileInputStream File = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Test_NG4\\Properties_File.proprties");
java.util.Properties p = new java.util.Properties();
	p.load(File);
	String Value = p.getProperty(Key);
	return Value;
}



}
