package markoSovilj.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class BillPaymentServicePage extends AbstractComponents {
	
	WebDriver driver;
	
	public BillPaymentServicePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css= "input[name='payee.name']")
	WebElement payeeName;
	
	@FindBy (css= "input[name='payee.address.street']")
	WebElement payeeStreet;
	
	@FindBy (css= "input[name='payee.address.city']")
	WebElement payeeCity;
	
	@FindBy (css= "input[name='payee.address.state']")
	WebElement payeeState;
	
	@FindBy (css= "input[name='payee.address.zipCode']")
	WebElement payeeZipCode;
	
	@FindBy (css= "input[name='payee.phoneNumber']")
	WebElement payeePhoneNumber;
	
	@FindBy (css= "input[name='payee.accountNumber']")
	WebElement payeeAccountNumber;
	
	@FindBy (css= "input[name='verifyAccount']")
	WebElement payeeVerifyAccount;
	
	@FindBy (css= "input[name='amount']")
	WebElement amountToPay;
	
	@FindBy (css= "select[name='fromAccountId']")
	WebElement fromAccountId;
	
	@FindBy (css= "input[value='Send Payment']")
	WebElement sendPaymentBtn;
	
	
	public void setPayeeInformation() {
		billPayLnk.click();
		
		payeeName.sendKeys("Petar Peric");
		payeeStreet.sendKeys("Majke Jevrosime");
		payeeCity.sendKeys("Beograd");
		payeeState.sendKeys("Serbia");
		payeeZipCode.sendKeys("123321");
		payeePhoneNumber.sendKeys("+38165999999");
		payeeAccountNumber.sendKeys("333555");
		payeeVerifyAccount.sendKeys("333555");
		amountToPay.sendKeys("150");
	}
	
	public void setPaymentAccount(String accountNumber) {
		fromAccountId.click();
		driver.findElement(By.xpath("(//option[@value='"+ accountNumber +"'])")).click();
		sendPaymentBtn.click();
	}
	
//	driver.findElement(By.cssSelector("select[name='fromAccountId']")).click();
//	driver.findElement(By.xpath("(//option[@value='"+ newAccNum +"'])")).click();
//	driver.findElement(By.cssSelector("input[value='Send Payment']")).click();
	
}
