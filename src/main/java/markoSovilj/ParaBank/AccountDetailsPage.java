package markoSovilj.ParaBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class AccountDetailsPage extends AbstractComponents {
	
	WebDriver driver;
	
	public AccountDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "accountId")
	WebElement accountId;
	
	@FindBy (id = "accountType")
	WebElement accountType;
	
	@FindBy (id = "balance")
	WebElement balance;
	
	@FindBy (id = "availableBalance")
	WebElement availableBalance;
	
	public String getAccountId() {
		return accountId.getText();
	}
	
	public String getAccountType() {
		return accountType.getText();
	}

	public String getBalance() {
		String formatedBalance = balance.getText();
		return formatedBalance.replace("$", "");
	}

	public String getAvailableBalance() {
		String formatedAvailableBalance = availableBalance.getText();
		return formatedAvailableBalance.replace("$", "");
	}
	
}
