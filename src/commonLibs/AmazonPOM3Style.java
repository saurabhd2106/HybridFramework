package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPOM3Style {
	
	public Select oSearchList;
	
	@FindBy (id="twotabsearchtextbox")
	public WebElement oSearchEdit;
	
	@FindBy (id="searchDropdownBox")
	public WebElement oSearchDropdown;
	
	@FindBy (xpath="//input[@value='Go']")
	public WebElement oSearchButton;
	
	public AmazonPOM3Style(WebDriver oDriver){
		try {
			
			PageFactory.initElements(oDriver, this);
			oSearchList = new Select(oSearchDropdown);
			
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
