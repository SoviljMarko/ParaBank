package markoSovilj.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class TransferFoundsPage extends AbstractComponents {
	
	WebDriver driver;
	
	public TransferFoundsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (id = "amount")
	WebElement setAmount;
	
	@FindBy (id = "fromAccountId")
	WebElement setFromAccountId;
	
	@FindBy (id = "toAccountId")
	WebElement setToAccountId;
	
	@FindBy (css = "input[type='submit']")
	WebElement transferBtn;
	
	
	
	public void fundsTransferBetweenAccounts(String newAccNum) {
		transferFoundsLnk.click();
		
		setAmount.sendKeys("50");
		setToAccountId.click();
		driver.findElement(By.xpath("(//option[@value='"+ newAccNum +"'])[2]")).click();
		transferBtn.click();
	}

}
