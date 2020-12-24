package AppHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	@Before(order=0)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		driver=driverFactory.init_driver(new ConfigReader().init_prop().getProperty("browser"));
	}
	
	@After(order=0)
	public void quit() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			
		String screenshotName =	scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
		
		
		}
	}
}
