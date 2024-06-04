package markoSovilj.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resources.UserTestConstants;

import AbstractComponents.AbstractComponents;

public class RegisterPage extends AbstractComponents{
	

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id = "customer.firstName")
	WebElement firstName;
	
	@FindBy (id = "customer.lastName")
	WebElement lastName;
	
	@FindBy (id = "customer.address.street")
	WebElement adress;
	
	@FindBy (id = "customer.address.city")
	WebElement city;
	
	@FindBy (id = "customer.address.state")
	WebElement state;
	
	@FindBy (id = "customer.address.zipCode")
	WebElement zipCode;
	
	@FindBy (id = "customer.phoneNumber")
	WebElement phoneNumber;
	
	@FindBy (id = "customer.ssn")
	WebElement ssnNumber;

	@FindBy (id = "customer.username")
	WebElement username;
	
	@FindBy (id = "customer.password")
	WebElement password;
	
	@FindBy (id = "repeatedPassword")
	WebElement repeatedPassword;
	
	@FindBy (css = "input[value='Register']")
	WebElement submitBtn;
	
	@FindBy (xpath = "//div[2]/h1")
	WebElement welcomeUsername;
	
	@FindBy (xpath = "//div[2]/p[1]")
	WebElement confirmationMessage;
	
	
	public void NewUserRegister() {

		registerLnk.click();
		
		firstName.sendKeys(UserTestConstants.USER_FIRST_NAME);
		lastName.sendKeys(UserTestConstants.USER_LAST_NAME);
		adress.sendKeys(UserTestConstants.USER_STREET);
		city.sendKeys(UserTestConstants.USER_CITY);
		state.sendKeys(UserTestConstants.USER_STATE);
		zipCode.sendKeys(UserTestConstants.USER_STATE);
		phoneNumber.sendKeys(UserTestConstants.USER_PHONE_NUMBER);
		ssnNumber.sendKeys(UserTestConstants.USER_SSN_NUMBER);
		username.sendKeys(UserTestConstants.USER_USERNAME);
		password.sendKeys(UserTestConstants.USER_PASSWORD);
		repeatedPassword.sendKeys(UserTestConstants.USER_PASSWORD);
		submitBtn.click();
	}
	
	public void NewUserRegisterAndLogOut() {

		registerLnk.click();
		
		firstName.sendKeys(UserTestConstants.USER_FIRST_NAME);
		lastName.sendKeys(UserTestConstants.USER_LAST_NAME);
		adress.sendKeys(UserTestConstants.USER_STREET);
		city.sendKeys(UserTestConstants.USER_CITY);
		state.sendKeys(UserTestConstants.USER_STATE);
		zipCode.sendKeys(UserTestConstants.USER_STATE);
		phoneNumber.sendKeys(UserTestConstants.USER_PHONE_NUMBER);
		ssnNumber.sendKeys(UserTestConstants.USER_SSN_NUMBER);
		username.sendKeys(UserTestConstants.USER_USERNAME);
		password.sendKeys(UserTestConstants.USER_PASSWORD);
		repeatedPassword.sendKeys(UserTestConstants.USER_PASSWORD);
		submitBtn.click();
		
		logOutLnk.click();
	}
	
	public String RegisterConfirmationMessages() {
		String message = welcomeUsername.getText() + ". " + confirmationMessage.getText();
		return(message);
	}
	
	
}
