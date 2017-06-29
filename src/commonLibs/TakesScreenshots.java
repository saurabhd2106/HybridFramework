package commonLibs;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibsInterfaces.ITakesScreenshot;



public class TakesScreenshots implements ITakesScreenshot {
	
	WebDriver Driver;
	
	public TakesScreenshots(WebDriver Driver){
		this.Driver = Driver;
	}

	@Override
	public void captureAndSaveScreenshot(String fileName) throws Exception {
		
		File imgFile, tmpFile;
		
		imgFile = new File(fileName);
		
		if(imgFile.exists()){
			throw new Exception("File already exists..");
		}
		
		TakesScreenshot camera;
		
		camera = (TakesScreenshot) Driver;
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
		
	}

}
