package framework_AnyDo.AnyDo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Resources.base;

public class Home_Page extends base
{
	/*public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods= {"login"})
	public void CreateTask()
	{
		HomePage hp = new HomePage(driver);
		hp.createTask().click();
		hp.taskName().sendKeys("Assigned to user");
		hp.submitTask().click();
	}
*/
}
