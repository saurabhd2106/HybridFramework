package commonLibs;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibsInterfaces.IWindowHandle;

public class WindowHandleControl implements IWindowHandle{
	
	WebDriver Driver;
	
	public WindowHandleControl(WebDriver Driver){
		this.Driver = Driver;
	}
	
	@Override
	public void switchToChildWindow() throws Exception {
		
		String childWindow;
		
		childWindow = getWindowHandles().toArray()[1].toString();
		
		Driver.switchTo().window(childWindow);
		
	}

	@Override
	public void switchToParentWindow() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWindowHandle() throws Exception {
		
		return Driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		
		return Driver.getWindowHandles();
	}

}
