package com.miniProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pomNormal {

		public WebDriver driver;
		
		//Constructor
		pomNormal(WebDriver driver)
		{
			this.driver=driver;
		}
		
		// locators
		By btn_createAccount_loc=By.xpath("//*[@id='signin_info']/a[2]");
		By links_loc=By.tagName("a");
		By link_terms_loc=By.xpath("//*[@id='tblcrtac']/tbody/tr[36]/td/a[1]");
		
		
		
		//Action methods
		
		public void clickCreateAccount()
		{
			driver.findElement(btn_createAccount_loc).click(); 
		}
		
		public List<WebElement> links()
		{
			return driver.findElements(By.tagName("a"));
		}
		
		public void termsLink()
		{
			driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[36]/td/a[1]")).click();
		}
		
		
		
	}


