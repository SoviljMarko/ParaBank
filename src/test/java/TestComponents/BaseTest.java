package TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public static WebDriver driver;
	
	public WebDriver Initialization() {
		
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
}
