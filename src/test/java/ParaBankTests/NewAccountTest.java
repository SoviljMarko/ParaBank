package ParaBankTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AbstractComponents.AbstractComponents;
import Resources.UserTestConstants;
import TestComponents.BaseTest;
import markoSovilj.ParaBank.AccountDetailsPage;
import markoSovilj.ParaBank.OpenNewAccountPage;

public class NewAccountTest extends BaseTest{
	
	WebDriver driver;
	
	@Test
	public void userLogIn() {
		AbstractComponents abstractComponents = new AbstractComponents(driver);
		abstractComponents.CustomerLogIn(UserTestConstants.USER_USERNAME, UserTestConstants.USER_PASSWORD);
		
		OpenNewAccountPage newAccountPage = new OpenNewAccountPage(driver);
		newAccountPage.addNewAccount();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		String forWaitPurpose = driver.findElement(By.id("accountId")).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("accountId"), forWaitPurpose));
		
		System.out.println("*************************************************");
		
		AccountDetailsPage accDetailsPage = new AccountDetailsPage(driver);
		
		System.out.println("New ACC Number: " + accDetailsPage.getAccountId());
		System.out.println("New ACC Type: " + accDetailsPage.getAccountType());
		System.out.println("New ACC Balance: " + accDetailsPage.getBalance());
		System.out.println("New ACC Available Balance: " + accDetailsPage.getAvailableBalance());
				
		Assert.assertEquals(accDetailsPage.getAvailableBalance(), "100.00");
	}
	
	@BeforeMethod
	public void begin() {
		driver = Initialization();
	}
	
	@AfterMethod
	public void finish() {
		driver.close();
	}
}
