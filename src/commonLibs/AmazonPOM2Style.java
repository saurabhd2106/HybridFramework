package commonLibs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonPOM2Style {
	public WebElement oSearchEdit;
	public Select oSearchList;
	public WebElement oSearchButton;
	 
	public AmazonPOM2Style(WebDriver oDriver){
		try {
			oSearchEdit = oDriver.findElement(By.id("twotabsearchtextbox"));
			
			oSearchList = new Select(oDriver.findElement(By.id("searchDropdownBox")));
			
			oSearchButton = oDriver.findElement(By.xpath("//input[@value='Go']"));
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
	}
	
	public void searchProduct(String sProduct, String sCategory){
		
		oSearchEdit.sendKeys(sProduct);
		oSearchList.selectByVisibleText(sCategory);
		oSearchButton.click();
	}

}
