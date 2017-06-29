package commonLibs;


import org.openqa.selenium.WebElement;

import commonLibsInterfaces.ITextbox;

public class TextboxControls implements ITextbox{
	
	@Override
	public void setText(WebElement element, String textToSet) throws Exception {
		
		element.sendKeys(textToSet);
		
	}

	@Override
	public void clearText(WebElement element) throws Exception {
		
		element.clear();
	}
	

}
