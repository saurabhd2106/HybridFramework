package commonLibs;

import org.openqa.selenium.WebElement;

import commonLibsInterfaces.IWebElementControl;

public class WebElementControls implements IWebElementControl{

	@Override
	public void click(WebElement element) throws Exception {
		
		element.click();
		
	}

	@Override
	public String getText(WebElement result) throws Exception {
		// TODO Auto-generated method stub
		return result.getText();
	}

	@Override
	public String getAttribute(WebElement element, String attribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(attribute);
	}

	@Override
	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		return element.getCssValue(csspropertyName);
	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
		
		return element.isEnabled();
	}

	@Override
	public boolean isElementVisible(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

}
