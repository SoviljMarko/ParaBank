package ParaBankTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AbstractComponents.AbstractComponents;
import Resources.UserTestConstants;
import TestComponents.BaseTest;
import markoSovilj.ParaBank.AccountsOverviewPage;
import markoSovilj.ParaBank.RegisterPage;

public class RegistrationAndLogInTest extends BaseTest{
	
	WebDriver driver;
	
	@Test
	public void userRegistration() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.NewUserRegister();
		
		Assert.assertEquals(registerPage.RegisterConfirmationMessages(),UserTestConstants.REGISTRATION_MESSAGE);
	}
	
//	@Test (dependsOnMethods = {"userRegistration"})
//	public void userLogIn() {
//		AbstractComponents abstractComponents = new AbstractComponents(driver);
//		abstractComponents.CustomerLogIn(UserTestConstants.USER_USERNAME, UserTestConstants.USER_PASSWORD);
//	}
//	
//	@Test (dependsOnMethods = {"userRegistration"})
//	public void userLogInAndAccountOverview() {
//		AbstractComponents abstractComponents = new AbstractComponents(driver);
//		abstractComponents.CustomerLogIn(UserTestConstants.USER_USERNAME, UserTestConstants.USER_PASSWORD);
//		
//		AccountsOverviewPage accOverviewPage = new AccountsOverviewPage(driver);
//		
//		System.out.println("Initial ACC Number: " + accOverviewPage.getAccountNumber());
//		System.out.println("Balance Amount: " + accOverviewPage.getBalanceAmount());
//		System.out.println("Available Amount: " + accOverviewPage.getAavailableAmount());
//		System.out.println("Total Amount: " + accOverviewPage.getTotalAmount());
//	}
	
	@BeforeMethod
	public void begin() {
		driver = Initialization();
	}
	
	@AfterMethod
	public void finish() {
		driver.close();
	}
	
}
