package commonLibs;

import org.openqa.selenium.WebElement;

import commonLibsInterfaces.ICheckboxControl;

public class CheckboxControl implements ICheckboxControl{

	@Override
	public void changeCheckBoxStatus(WebElement element, boolean status) throws Exception {
		
		if (!element.isSelected() && status){
			element.click();
		} else if(element.isSelected() && status){
			element.click();
		}
		
	}

	
}
