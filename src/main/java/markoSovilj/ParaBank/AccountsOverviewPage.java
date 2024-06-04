package markoSovilj.ParaBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class AccountsOverviewPage extends AbstractComponents {
	
	WebDriver driver;
	
	public AccountsOverviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr/td[1]/a")
	WebElement initialAccountNumber;
	
	@FindBy(xpath = "//tr[1]/td[2]")
	WebElement rawBalance;
	
	@FindBy(xpath = "//tr[1]/td[3]")
	WebElement rawAavailableAmount;
	
	@FindBy(xpath = "//tr[2]/td[2]")
	WebElement rawTotalAmount;
	
	public String getAccountNumber() {
		return initialAccountNumber.getText();
	}
	
	public String getBalanceAmount() {
		String balanceValue = rawBalance.getText();
		return balanceValue.replace("$", "");
	}

	public String getAavailableAmount() {
		String availableValue = rawAavailableAmount.getText();
		return availableValue.replace("$", "");
	}

	public String getTotalAmount() {
		String totalValue = rawTotalAmount.getText();
		return totalValue.replace("$", "");
	}
	
	
}
