package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//a[text()='Register']")
	protected
	WebElement registerLnk;
	
	@FindBy (xpath = "//a[text()='Log Out']")
	protected
	WebElement logOutLnk;
	
	@FindBy (xpath = "//a[text()='Open New Account']")
	protected
	WebElement openNewAccLnk;
	
	@FindBy (css = "a[href='transfer.htm']")
	protected
	WebElement transferFoundsLnk;
	
	@FindBy (css = "a[href='billpay.htm']")
	protected
	WebElement billPayLnk;
	
	@FindBy (css = "input[name='username']")
	WebElement userNameInput;
	
	@FindBy (css = "input[name='password']")
	WebElement passwordInput;
	
	@FindBy (css = "input[value='Log In']")
	WebElement logInBtn;
	
	public void CustomerLogIn(String username, String password) {
		userNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		logInBtn.click();
		
	}
	
}
