package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import commonLibs.DropdownControls;
import commonLibs.TextboxControls;
import commonLibs.WebElementControls;

public class EbayPOM2Style {
	
	private WebElement searchBox;
	
	private WebElement searchDropdown;
	
	private WebElement searchButton;
	
	private TextboxControls textbox;
	
	private DropdownControls dropdown;
	
	private WebElementControls element;
	
	private WebElement result;
	
	public EbayPOM2Style(WebDriver Driver){
		
		textbox = new TextboxControls();
		
		element = new WebElementControls();
		
		dropdown = new DropdownControls();
		
		searchBox = Driver.findElement(By.id("gh-ac"));
		
		searchDropdown = Driver.findElement(By.id("gh-cat"));
		
		searchButton = Driver.findElement(By.id("gh-btn"));
		
		result = Driver.findElement(By.className("listingscnt"));
	}
	
	public void searchItem(String product, String category) throws Exception{
		
		textbox.setText(searchBox, product);
		
		dropdown.selectViaVisibleText(searchDropdown, category);
		
		element.click(searchButton);
		
		System.out.println(element.getText(result));
	}
	
	
}
