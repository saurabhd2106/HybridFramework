package commonLibs;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibsInterfaces.IDriver;

public class CommonDriver implements IDriver{
	
	private WebDriver Driver;
	private long pageLoadTimeout;
	private long elementDetectionTimeout;
	
	public static Logger log = Logger.getLogger(IDriver.class);
	
	public CommonDriver(String browserType) throws Exception {
		
		PropertyConfigurator.configure("C:\\Users\\Saurabh Dhingra\\workspace\\ModularFramework\\ModularFramework\\config\\log4j.properties");
		
		SimpleLayout layout = new SimpleLayout(); 
		
		FileAppender appender = new FileAppender(layout,"log/MercuryTravel."+new Date().getTime()+".log",false);
		
		log.addAppender(appender); 
		
		pageLoadTimeout = 30l;
		elementDetectionTimeout = 10l;
		
		//remove white space from the end..
		browserType = browserType.trim();
		
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\chromedriver_win32\\chromedriver.exe");
			
			Driver = new ChromeDriver();
			log.info("Chrome Driver Invoked");
			
			log.warn("Its a warninhg..");
			break;
		
		case "firefox":
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\geckodriver-v0.15.0-win64\\geckodriver.exe");
			
			Driver = new FirefoxDriver();
			log.info("Firefox Driver Invoked");
			break;

		default:
			log.error("Invalid BrowserType - "+ browserType);
			throw new Exception("Invalid BrowserType - "+ browserType);
		}
		
	}

	//getter - to get the instance of the browser
	public WebDriver getDriver(){
		log.info("Getting the instance of Browser..");
		return Driver;
	}
	
	
	@Override
	public void openBrowser(String url) throws Exception {
		
		
		log.info("Trimming URL to remove white spaces");
		url = url.trim();
		
		if(url.isEmpty()){
			url = "about:blank";
		}
		
		log.info("Maximising window");
		Driver.manage().window().maximize();
		log.info("Maximised window");
		
		log.info("Deleting Cookies");
		Driver.manage().deleteAllCookies();
		
		log.info("Setting Page Load Time");
		Driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		log.info("Setting Element Detection TImeout");
		Driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		Driver.get(url);
	}

	@Override
	public void closeBrowser() throws Exception {

		Driver.close();
		
	}

	@Override
	public void closeAllBrowser() throws Exception {
		Driver.quit();
		
	}

	//Setter - to set value of page load timeout
	@Override
	public void setPageLoadTimeout(long pageLoadTimeout) throws Exception {
		
		this.pageLoadTimeout = pageLoadTimeout;
	}

	@Override
	public void setElementDetectionTimeout(long elementDetectionTimeout) throws Exception {
		this.elementDetectionTimeout = elementDetectionTimeout;
		
	}

	@Override
	public String getTitle() throws Exception {
		
		return Driver.getTitle();
	}

	@Override
	public String getPageSource() throws Exception {
		
		return Driver.getPageSource();
	}

	@Override
	public String getCurrentUrl() throws Exception {
		return Driver.getCurrentUrl();
		
	}

	@Override
	public void navigateTo(String url) throws Exception {

		Driver.navigate().to(url);
		
	}

	@Override
	public void navigateRefresh() throws Exception {
		Driver.navigate().refresh();
		
		
	}

	@Override
	public void navigateForward() throws Exception {
		Driver.navigate().forward();
		
	}

	@Override
	public void navigateBack() throws Exception {

		Driver.navigate().back();
		
	}

}
