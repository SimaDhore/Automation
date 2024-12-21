package base_Utility_Class;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pomInTestNG.SwagLabLoginPage2;
public class Test_Class extends BaseClass
{
	SwagLabLoginPage2 Login;
	int TCID;
@BeforeClass
public void Initialization () throws IOException
{ 
		initializeBrowser ();
        TCID = 101;
}

@BeforeMethod
public void LogIn () throws InterruptedException, EncryptedDocumentException, IOException
{
	TCID = 102;
	Login = new SwagLabLoginPage2(driver);
	Login.inputUN(UtilityClass.Properties("UN"));
	Login.inputPWD(UtilityClass.Properties("PWD"));
	Login.clickOnLogin();
	Thread.sleep(2000);
}
@Test
public void VerifyError () throws InterruptedException, EncryptedDocumentException, IOException
{
	TCID = 103;
	String Actual = Login.MSG();
	String Expected = UtilityClass.SheetData(0, 2);
	Thread.sleep(2000);
	if(Actual.contains(Expected))
	{System.out.println("Pass");}
	else
	{System.out.println("Fail");}
}
@AfterMethod
public void CloseBrowser (ITestResult S1) throws IOException 
{
	if(S1.getStatus()==ITestResult.FAILURE)
	{UtilityClass.Screenshot(driver, TCID);}
	
	driver.quit();
	}
}
