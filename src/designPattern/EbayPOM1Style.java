package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayPOM1Style {
	
	public WebElement searchBox;
	
	public WebElement searchDropdown;
	
	public WebElement searchButton;
	
	public EbayPOM1Style(WebDriver Driver){
		
		searchBox = Driver.findElement(By.id("gh-ac"));
		
		searchDropdown = Driver.findElement(By.id("gh-cat"));
		
		searchButton = Driver.findElement(By.id("gh-btn"));
	}

}
