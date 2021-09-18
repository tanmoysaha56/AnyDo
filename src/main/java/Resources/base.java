package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	prop.load(fis);
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.contains("chrome"))
	{
		System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		if(browserName.contains("headless"))
		{
			option.addArguments("headless");
		}
		driver = new ChromeDriver(option);
	}
	else if(browserName.contains("firefox"))
	{
		///
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	}
	
	

}
