package ParaBankTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.AbstractComponents;
import TestComponents.BaseTest;
import markoSovilj.ParaBank.RegisterPage;

public class RegistrationAndLogInTest extends BaseTest{
	
	WebDriver driver;
	
	@Test
	public void userRegistration() {
		driver = Initialization();
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.NewUserRegister();
		
		Assert.assertEquals(registerPage.RegisterConfirmationMessages(),
				"Welcome Marko85. Your account was created successfully. You are now logged in.");
		driver.close();
	}
	
	@Test (dependsOnMethods = {"userRegistration"})
	public void userLogIn() {
		driver = Initialization();
		AbstractComponents abstractComponents = new AbstractComponents(driver);
		abstractComponents.CustomerLogIn("Marko85", "StarWars1");
		driver.close();
	}
	
}
