package com.qa.gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.WebDriverHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Basepage {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest loggerr;
	String path="C:\\Users\\fahim\\eclipse-workspace\\com.qa.gmail\\src\\main\\resources\\config.properties";
public Basepage() {
	try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream(path);
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*@BeforeTest
public static void setExtent() {
	extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
	extent.addSystemInfo("Host Name", "Fahim-PC");
	extent.addSystemInfo("SQA : ", "Fahim Ahmed");
	extent.addSystemInfo("Environment", "Automation");
}
@AfterTest
public void endReport() {
	extent.flush();
	extent.close();
}
*/

public void initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fahim\\eclipse-workspace\\webAutomate\\driver\\chromedriver.exe");
		//WebDriver driver= new HtmlUnitDriver();
		/*ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("window-size=1400,800");
		chromeOptions.addArguments("headless");*/
		driver=new ChromeDriver();
	}else if(browserName.equals("firefox")){
		System.setProperty("www.gecko.driver", "C:\\Users\\fahim\\eclipse-workspace\\webAutomate\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}

}
