package framework_AnyDo.AnyDo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Resources.base;

public class Login_Page extends base
{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void login()
	{
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.login().click();
		lp.loginWithEmail().click();
		lp.email().sendKeys("saha.tanmoy56@gmail.com");
		lp.next().click();
		lp.password().sendKeys("Password@12345");
		lp.submit().click();
	}
	
	@Test(dependsOnMethods= {"login"})
	public void CreateTask()
	{
		HomePage hp = new HomePage(driver);
		hp.createTask().click();
		hp.taskName().sendKeys("Assigned to user");
		hp.submitTask().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
