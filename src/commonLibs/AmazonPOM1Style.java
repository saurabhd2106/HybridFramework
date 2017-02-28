package commonLibs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonPOM1Style {
	public WebElement oSearchEdit;
	public Select oSearchList;
	public WebElement oSearchButton;
	 
	public AmazonPOM1Style(WebDriver oDriver){
		try {
			oSearchEdit = oDriver.findElement(By.id("twotabsearchtextbox"));
			
			oSearchList = new Select(oDriver.findElement(By.id("searchDropdownBox")));
			
			oSearchButton = oDriver.findElement(By.xpath("//input[@value='Go']"));
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
	}

}
