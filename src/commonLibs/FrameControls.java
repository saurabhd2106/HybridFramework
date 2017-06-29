package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibsInterfaces.IFrameControls;

public class FrameControls implements IFrameControls{
	
	private WebDriver Driver;
	
	public FrameControls(WebDriver Driver){
		this.Driver = Driver;
	}

	@Override
	public void switchToFrame(String frameId) throws Exception {
		
		Driver.switchTo().frame(frameId);
		
	}

	@Override
	public void switchToFrame(WebElement element) throws Exception {
		Driver.switchTo().frame(element);
		
	}

	@Override
	public void switchToFrame(int index) throws Exception {
		Driver.switchTo().frame(index);
		
	}

	@Override
	public void switchToDefaultContent() throws Exception {
		Driver.switchTo().defaultContent();
		
	}

}
