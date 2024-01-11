package com.miniProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pomPageFactory {

		public WebDriver driver;
		
		//Constructor
		pomPageFactory(WebDriver driver)
		{
			this.driver=driver;
		}
		
		// locators
		@FindBy(xpath="//*[@id='signin_info']/a[2]") WebElement create;
		By links_loc=By.tagName("a");
		@FindBy(tagName="a") List<WebElement> links;
		@FindBy(xpath="//*[@id='tblcrtac']/tbody/tr[36]/td/a[1]") WebElement terms;
		
		
		
		//Action methods
		
		public void clickCreateAccount()
		{
			create.click(); 
		}
		
		public List<WebElement> links()
		{
			return links;
		}
		
		public void termsLink()
		{
			terms.click();
		}
		
		
		
	}


