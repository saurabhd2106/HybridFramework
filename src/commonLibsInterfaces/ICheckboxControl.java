package commonLibsInterfaces;

import org.openqa.selenium.WebElement;

public interface ICheckboxControl {
	
	public void changeCheckBoxStatus(WebElement element, boolean status) throws Exception;

}
