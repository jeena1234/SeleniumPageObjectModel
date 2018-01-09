package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger");
	
	public static Properties OR= new Properties();
	
	public static Properties Config= new Properties(); 
	
	public static FileInputStream fis;
	
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp(ITestContext context){
		
		
		System.out.println("Print context"+context);
        if(driver==null){
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//Config.properties");
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Config.getProperty("browser").equals("firefox")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//geckodriver.exe");
				
				
				driver = new FirefoxDriver();
				log.debug("Firefox Launched");
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Chrome Driver chosen");
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			
			System.out.println(Config.getProperty("testsiteurl"));
			driver.navigate().to(Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5L);	
			driver.manage().window().maximize();
		}

	}


public  void teardown(){
	
	
	driver.quit();	
	
}


public static  boolean isElementPresent(By locator){
	boolean bl=false;
	try{
		bl= driver.findElement(locator).isDisplayed();

}
	catch(Exception e){
		System.out.println(e);
		
	}
	return bl;
	
}

public static boolean SoftAssert(Boolean condition,String message){
	
	boolean bvalue=false;
	try{
		Assert.assertTrue(condition, message);
		bvalue=true;
	
	}catch(Exception e){
		
		System.out.println(e);
	
	}
	return bvalue;
	
}
		
		
	
	
	

	

}
