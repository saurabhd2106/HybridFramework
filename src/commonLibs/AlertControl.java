package commonLibs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibsInterfaces.IAlert;

public class AlertControl implements IAlert{
	
	private WebDriver Driver;
	private Alert alert;
	
	public AlertControl(WebDriver Driver){
		this.Driver = Driver;
	}
	
	private Alert getAlert(){
		alert = Driver.switchTo().alert();
		return alert;
	}


	@Override
	public void acceptAlert() throws Exception {
		
		getAlert().accept();
	}

	@Override
	public void rejectAlert() throws Exception {
		getAlert().dismiss();
		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		
		return getAlert().getText();
	}

	@Override
	public boolean isAlertPresent() throws Exception {
		WebDriverWait wait = new WebDriverWait(Driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		
		return true;
	}

}
