package framework_AnyDo.AnyDo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Resources.base;

public class Login_Page extends base
{
	public WebDriver driver;
	public Xls_Reader reader;
	public LoginPage lp;
	public HomePage hp;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void login()
	{
		lp = new LoginPage(driver);
		lp.login().click();
		lp.loginWithEmail().click();
		
		//excel data read
		reader = new Xls_Reader(prop.getProperty("excelPath"));
		String userName = reader.getCellData("credentials", "Email", 2);
		String Password = reader.getCellData("credentials", "Password", 2);
		
		lp.email().sendKeys(userName);		 //from excel file
		//lp.email().sendKeys(prop.getProperty("email"));    	//from properties file
		lp.next().click();
		
		lp.password().sendKeys(Password);	//from excel file
		//lp.password().sendKeys(prop.getProperty("password"));		//from properties file
		lp.submit().click();
	}
	
	@Test(dependsOnMethods= {"login"})
	public void CreateTask()
	{
		hp = new HomePage(driver);
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
