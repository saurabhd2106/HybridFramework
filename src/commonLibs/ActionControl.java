package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibsInterfaces.IActionControl;

public class ActionControl implements IActionControl {
	
	private WebDriver Driver;
	
	public ActionControl(WebDriver Driver){
		this.Driver = Driver;
	}
	
	private Actions getAction(){
		Actions action = new Actions(Driver);
		return action;
	}
	
	@Override
	public void dragAndDrop(WebElement element1, WebElement element2) throws Exception {

		
		getAction().dragAndDrop(element1, element2).build().perform();;
	}

	@Override
	public void moveToElement(WebElement element) throws Exception {
		
		getAction().moveToElement(element).build().perform();
		
	}

	@Override
	public void rightClick(WebElement element) throws Exception {
		
		getAction().contextClick().build().perform();
		
	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		
		getAction().doubleClick().build().perform();
		
	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		
		getAction().moveToElement(element).click().build().perform();
		
	}

}
