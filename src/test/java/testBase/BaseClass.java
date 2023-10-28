package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver d;
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) 
	{
	
	rb=ResourceBundle.getBundle("config"); // load config.properties file
		
	logger=LogManager.getLogger(this.getClass());  //logging
	
	// Write below 2 lines of code if you don't want to display the text
	// 'Chrome is being controlled by automated test software' while executing the script
	// and have to pass 'options' to d.ChromeDriver() parameter.
	//ChromeOptions options=new ChromeOptions();
	//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
	if(browser.equals("chrome")) 
	{
		d=new ChromeDriver();
   	}
	
	else if (browser.equals("edge")) 
	{
		d=new EdgeDriver();
   	}
	else 
	{
		d=new FirefoxDriver();
   	}
	
	 d.manage().deleteAllCookies();
	 WebDriverManager.chromedriver().setup();
	 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 //d.get("https://demo.opencart.com/");
	 
      d.get(rb.getString("appURL1")); // No need to hard code the URL
	 //d.get(rb.getString("appURL2"));
	 d.manage().window().maximize();
	 
	}
	
	
	@AfterClass
	public void tearDown()
	{
		d.close();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) d;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
