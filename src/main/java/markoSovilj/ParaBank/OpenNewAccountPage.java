package markoSovilj.ParaBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OpenNewAccountPage extends AbstractComponents {
	
	WebDriver driver;
	
	public OpenNewAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "type")
	WebElement accTypeDropDown;
	
	@FindBy(xpath = "//option[1]")
	WebElement optionOneCheckings;
	
	@FindBy(xpath = "//option[2]")
	WebElement optionTwoSavings;
	
	@FindBy (css = "input[value='Open New Account']")
	WebElement openNewAccBtn;
	
	@FindBy (id = "newAccountId")
	WebElement newAccountIdLnk;
	
	
	public void addNewAccount() {
		openNewAccLnk.click();
		
		accTypeDropDown.click();
		optionTwoSavings.click();
		openNewAccBtn.click();
		openNewAccBtn.click();
		newAccountIdLnk.click();
		
	}
	
	
//	driver.findElement(By.xpath("//a[text()='Open New Account']")).click();
//	driver.findElement(By.id("type")).click();
//	driver.findElement(By.xpath("//option[2]")).click();
//	driver.findElement(By.cssSelector("input[value='Open New Account']")).click();
//	driver.findElement(By.cssSelector("input[value='Open New Account']")).click();
	
	// driver.findElement(By.id("newAccountId")).click();

}
