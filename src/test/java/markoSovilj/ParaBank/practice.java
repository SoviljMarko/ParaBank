package markoSovilj.ParaBank;

import java.time.Duration;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestComponents.BaseTest;

public class practice {

	public static void main(String[] args) throws InterruptedException {
		
		
		BaseTest baseTest = new BaseTest();
		WebDriver driver = baseTest.Initialization();
		
		
		// making ACC-a and Log out
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.NewUserRegisterAndLogOut();
		
				
		// log in
		
		registerPage.CustomerLogIn("Marko85", "StarWars1");
		
	
		// grab info from ACC
		
		AccountsOverviewPage accOverviewPage = new AccountsOverviewPage(driver);
		
		String initialAccountNumber = accOverviewPage.getAccountNumber();
		
		System.out.println("Initial ACC Number: " + accOverviewPage.getAccountNumber());
		System.out.println("Balance Amount: " + accOverviewPage.getBalanceAmount());
		System.out.println("Available Amount: " + accOverviewPage.getAavailableAmount());
		System.out.println("Total Amount: " + accOverviewPage.getTotalAmount());
		
		
		// making new ACC
		
		OpenNewAccountPage newAccountPage = new OpenNewAccountPage(driver);
		newAccountPage.addNewAccount();
	
		
		// grab New ACC informations

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		String forWaitPurpose = driver.findElement(By.id("accountId")).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("accountId"), forWaitPurpose));
		
		System.out.println("*************************************************");
		
		AccountDetailsPage accDetailsPage = new AccountDetailsPage(driver);
		
		String newAccountNumber = accDetailsPage.getAccountId();
		
		System.out.println("New ACC Number: " + accDetailsPage.getAccountId());
		System.out.println("New ACC Type: " + accDetailsPage.getAccountType());
		System.out.println("New ACC Balance: " + accDetailsPage.getBalance());
		System.out.println("New ACC Available Balance: " + accDetailsPage.getAvailableBalance());
				
		Assert.assertEquals(accDetailsPage.getAvailableBalance(), "100.00");

		
		// Transfer from ACC to new ACC
		
		TransferFoundsPage transferFoundsPage = new TransferFoundsPage(driver);
		transferFoundsPage.fundsTransferBetweenAccounts(newAccountNumber);
				
		String waitPurpose = driver.findElement(By.xpath("//div[2]/p[1]")).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[2]/p[1]"), waitPurpose));
		
		String transferMessage = driver.findElement(By.xpath("//div[2]/p[1]")).getText();
		System.out.println(transferMessage);
		
		Assert.assertEquals(transferMessage, "$50.00 has been transferred from account #" + initialAccountNumber
							+ " to account #" + newAccountNumber + ".");

		
		System.out.println("*************************************************");
		
//		// payment to unknown ACC
		
		BillPaymentServicePage billPaymentServicePage = new BillPaymentServicePage(driver);
		billPaymentServicePage.setPayeeInformation();		
		billPaymentServicePage.setPaymentAccount(newAccountNumber);

		String purposeWait = driver.findElement(By.xpath("//div[@id='billpayResult']/p[1]")).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@id='billpayResult']/p[1]"), purposeWait));
		
		String text = driver.findElement(By.xpath("//div[@id='billpayResult']/p[1]")).getText();
		System.out.println(text);
		

		driver.findElement(By.xpath("//a[text()='Admin Page']")).click();
		driver.findElement(By.cssSelector("button[value='CLEAN']")).click();
		Thread.sleep(2000);
		
		driver.close();
	}

}
