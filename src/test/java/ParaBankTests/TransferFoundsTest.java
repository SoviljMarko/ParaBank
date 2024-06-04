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
import markoSovilj.ParaBank.AccountsOverviewPage;
import markoSovilj.ParaBank.OpenNewAccountPage;
import markoSovilj.ParaBank.TransferFoundsPage;

public class TransferFoundsTest extends BaseTest{
	
	WebDriver driver;
	
	@Test
	public void NewTransferFound() {
		AbstractComponents abstractComponents = new AbstractComponents(driver);
		abstractComponents.CustomerLogIn(UserTestConstants.USER_USERNAME, UserTestConstants.USER_PASSWORD);
		
		AccountsOverviewPage accOverviewPage = new AccountsOverviewPage(driver);
		String initialAccountNumber = accOverviewPage.getAccountNumber();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		OpenNewAccountPage newAccountPage = new OpenNewAccountPage(driver);
		newAccountPage.addNewAccount();
		
		String forWaitPurpose = driver.findElement(By.id("accountId")).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("accountId"), forWaitPurpose));
		
		AccountDetailsPage accDetailsPage = new AccountDetailsPage(driver);
		String newAccountNumber = accDetailsPage.getAccountId();
		
		TransferFoundsPage transferFoundsPage = new TransferFoundsPage(driver);
		transferFoundsPage.fundsTransferBetweenAccounts(newAccountNumber);
				
		
		String waitPurpose = driver.findElement(By.xpath("//div[2]/p[1]")).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[2]/p[1]"), waitPurpose));
		
		String transferMessage = driver.findElement(By.xpath("//div[2]/p[1]")).getText();
		System.out.println(transferMessage);
		
		Assert.assertEquals(transferMessage, "$50.00 has been transferred from account #" + initialAccountNumber
							+ " to account #" + newAccountNumber + ".");
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
