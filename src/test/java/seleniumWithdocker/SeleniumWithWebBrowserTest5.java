package seleniumWithdocker;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWithWebBrowserTest5 {
	WebDriver driver;

	static final String app_Url = "https://www.zomato.com/india";
	static final String host_Url = "http://localhost:4444/wd/hub";

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		EdgeOptions options = new EdgeOptions();
		driver = new RemoteWebDriver(new URL(host_Url), options);
		driver.get(app_Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void assertTitle() {
		String expectedTitle = "Best Restaurants";
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(expectedTitle));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
