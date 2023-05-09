package seleniumWithdocker;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWithWebBrowserTest {
	WebDriver driver;

	static final String app_Url = "https://www.google.com/";
	static final String host_Url = "http://localhost:4444/wd/hub";

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
//		FirefoxOptions options = new FirefoxOptions();
//		EdgeOptions options = new EdgeOptions();
		
		//I thing below lines of code are not required
		
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("start-maximized"); // open Browser in maximized mode
//		options.addArguments("disable-infobars"); // disabling infobars
//		options.addArguments("--disable-extensions"); // disabling extensions
//		options.addArguments("--disable-gpu"); // applicable to windows os only
//		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//		options.addArguments("--no-sandbox");

		driver = new RemoteWebDriver(new URL(host_Url), options);
		driver.get(app_Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void assertTitle() {
		String expectedTitle = "Google";
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(expectedTitle));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
