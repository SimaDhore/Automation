package pomInTestNG;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PomTestNGClass
{
	Sheet Sheet;
	WebDriver driver;
	SwagLabLoginPage2 Login;
	
@BeforeClass
@Test
public void Initialization () throws EncryptedDocumentException, IOException
{
//	FileInputStream File = new FileInputStream("D:\\Software Testing\\Automation\\Username Password.xlsx");
//	 Sheet = WorkbookFactory.create(File).getSheet("Sheet1");
	
//	driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.get("https://www.saucedemo.com");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
}

@BeforeTest
@Test
public void LogIn () throws InterruptedException
{
	Login = new SwagLabLoginPage2(driver);
	Login.inputUN(Sheet.getRow(0).getCell(0).getStringCellValue());
	Login.inputPWD(Sheet.getRow(0).getCell(1).getStringCellValue());
	Login.clickOnLogin();
	Thread.sleep(2000);
}

@Test
public void VerifyError () throws InterruptedException
{
	String Actual = Login.MSG();
	String Expected = Sheet.getRow(0).getCell(2).getStringCellValue();
	Thread.sleep(2000);
	if(Actual.contains(Expected))
	{System.out.println("Pass");}
	else
	{System.out.println("Fail");}
}

@AfterClass
@Test
public void CloseBrowser ()
{driver.quit();}

}
