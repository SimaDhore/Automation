package base_Utility_Class;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseClass 
{
	WebDriver driver;
public void initializeBrowser () throws IOException
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(UtilityClass.Properties("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
}

}
