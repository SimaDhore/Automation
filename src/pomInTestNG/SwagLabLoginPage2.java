package pomInTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage2 
{
	@FindBy (xpath="//input[@id='user-name']") private WebElement UserName;
	@FindBy (xpath="//input[@id='password']")private WebElement Password;
	@FindBy (xpath="//input[@id='login-button']")private WebElement LoginBtn;
    @FindBy (xpath="//h3[@data-test='error']") private WebElement ErrorMsg;

public SwagLabLoginPage2 (WebDriver driver)
{PageFactory.initElements(driver, this);}

public void inputUN (String UNValue)
{UserName.sendKeys(UNValue);}

public void inputPWD (String PWDValue)
{Password.sendKeys(PWDValue);}

public void clickOnLogin()
{LoginBtn.click();}

//public String MSG (String EXPMSG)
//{
//if(ACTMSG.contains(EXPMSG))
//{System.out.println("Pass");}
//else
//{System.out.println("Fail");}
//}

public String MSG ()
{
	String ACTMSG = ErrorMsg.getText();
    return ACTMSG;
    }
}
