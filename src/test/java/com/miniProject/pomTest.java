package com.miniProject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.excelUtils.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.List;
import java.util.Set; 

public class pomTest {
	WebDriver driver;
	//LoginPage lp;
	pomNormal lp;   
	  
	  @BeforeClass
	  public void createDriver() {
			  WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.rediff.com");  
		   
	  }
	    
	  @Test(priority=1)
	  public void validatePage() {
		  lp=new pomNormal(driver);
		  lp.clickCreateAccount();
	      // Validating the page title 
	      Assert.assertEquals(driver.getTitle(),"Rediffmail Free Unlimited Storage");
	      System.out.println("Title: "+ driver.getTitle());
	  }
	  
	  @Test(priority=2)
	  public void totalLinks() throws IOException {
		// Finding all the links on the page and printing their count 
	  	  List<WebElement> links = lp.links();
	      String filePath = System.getProperty("user.dir") + "/Links.xlsx";
	      System.out.println("Total number of links: " + links.size());

	      utilities.setCellData(filePath, "LinksData",0,0,"LINKS");
	      utilities.fillOrangeColor(filePath, "LinksData",0,0);
	      utilities.setCellData(filePath, "LinksData",0,1,"TEXT");
	      utilities.fillSkyBlueColor(filePath, "LinksData",0,1);
		  
	      int rowNum = 1;
	      int colNum = 0;

	      for (WebElement link : links) {
	          String href = link.getAttribute("href");
	          String text = link.getText();

	          utilities.setCellData(filePath, "LinksData", rowNum, colNum, href);
	          colNum++;
	          utilities.setCellData(filePath, "LinksData", rowNum, colNum, text);
	          rowNum++;
	          colNum=0;
	      }

	      System.out.println("Links and their texts written to Excel file successfully!");
	      
	  }
	  
	  @Test(priority=3)
	  public void windowHandling() {
		// Finding and clicking the 'Terms' link to open a new window 
	      lp.termsLink(); 
	      // Getting the parent window handle 
	      String parentHandle = driver.getWindowHandle(); 
	      // Getting all available window handles 
	      Set<String> windowHandles = driver.getWindowHandles(); 
	      // Switching to the child window 
	      for (String windowHandle : windowHandles) {
	    	  if (!windowHandle.equals(parentHandle)) {
	              driver.switchTo().window(windowHandle); 
	              break;
	    	  }
	      }
	      // Getting the title of the child window
	      String childWindowTitle = driver.getTitle();
	      // Validating the child window title
	    	  Assert.assertEquals(childWindowTitle,"Rediffmail: Terms and Conditions");
	          System.out.println("Child window 'Terms and Conditions' is opened."); 
	          System.out.println("Child window title matches: " + childWindowTitle); 
	        
	      // Closing the child window and switching back to the parent window
	      driver.close();
	      driver.switchTo().window(parentHandle);
	      
	  }
	  @AfterClass
	  public void quitbrowser() {
		  driver.quit();
	  }
	}



