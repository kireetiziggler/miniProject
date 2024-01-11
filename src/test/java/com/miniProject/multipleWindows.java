package com.miniProject;

//importing packages
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excelUtils.utilities;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;


public class multipleWindows {
	public static WebDriver driver;   //declaration of driver variable
   
    
    public WebDriver createDriver() {
        // Initialize the driver
        driver = driverSetup.getWebDriver();   //getting browser type from user
        driver.manage().window().maximize();    //maximize the browser
        driver.get("https://www.rediff.com");  //Opening the website in browser
        return driver;
    }

    public void validatePage() {
        //Validating the pagetitle of the window
        WebElement createAccountLink = driver.findElement(By.xpath("//*[@id='signin_info']/a[2]"));		// Finding the Create Account link by xpath
        createAccountLink.click();					//Clicking the link
        String pageTitle = driver.getTitle();		//getting title of the page

        if (pageTitle.equals("Rediffmail Free Unlimited Storage")) {	 //Validating the page title
            System.out.println("Page title matches: " + pageTitle);		//Printing if page title matches
        } else {														//else statement
            System.out.println("Page title is different: " + pageTitle);	//printing if page title is different
        }
    }

    public void totalLinks() throws IOException {
        // Finding all the links on the page
    	List<WebElement> links = driver.findElements(By.tagName("a"));				//finding element by tagName
    	String filePath = "C:\\Users\\2304004\\eclipse-workspace\\miniProject\\src\\test\\resources\\Links.xlsx";		//giving path for excel
    	System.out.println("Number of links in the webpage: " + links.size() );		//printing count of links
    	utilities.setCellData(filePath, "TestCase", 0, 0, "LINKS");					//writing "LINKS" heading into excel
    	utilities.setCellData(filePath, "TestCase", 0, 1, "TEXT");					//writing "TEXT" heading into excel
    	utilities.fillOrangeColor(filePath, "TestCase", 0, 0);						//filling orange colour for "LINKS" header
    	utilities.fillSkyBlueColor(filePath, "TestCase", 0, 1);						//filling orange colour for "TEXT" header
    	int rownum = 1;
    	int colnum=0;
    	 for (WebElement link : links) { 						//using for each loop with variable link
    	 String href = link.getAttribute("href"); 				//getting links to variable href 
    	 String text = link.getText();
    	 utilities.setCellData(filePath,"TestCase",rownum,colnum,href);		 // Create cells in the row and write data
    	 colnum++;
    	 utilities.setCellData(filePath,"TestCase",rownum,colnum,text);		 // Create cells in the row and write data
    	 rownum++;
    	 colnum=0;
    	 System.out.println(link.getAttribute("href") + " - " + link.getText());	//printing links
    	   
    	}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	System.out.println("Links and their texts written to Excel file successfully!");	//printing message
   }
    
    
 public void windowsHandling() {
        //Handling multiple windows by switching to child and parent windows
	 
        WebElement termsLink = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[36]/td/a[1]"));	// Finding the 'Terms and conditions' link to open a new window
        termsLink.click();		//clicking the terms and conditions link

        String parentHandle = driver.getWindowHandle();       // Getting the parent window handle
        Set<String> windowHandles = driver.getWindowHandles();  // Getting all available window handles
        for (String windowHandle : windowHandles) {		  		// Switching to the child window	
            if (!windowHandle.equals(parentHandle)) {
                driver.switchTo().window(windowHandle);			//switching to child window
                break;											//breaking the loop
            }
        }
        
        String childWindowTitle = driver.getTitle();        // Getting the title of the child window

        if (childWindowTitle.equals("Rediffmail: Terms and Conditions")) {		// Validating the child window title
            System.out.println("Child window 'Terms and Conditions' is opened.");	
            System.out.println("Child window title matches: " + childWindowTitle);
        } else {
            System.out.println("Child window different title: " + childWindowTitle);
        }

        driver.close();								//closing the current window
        driver.switchTo().window(parentHandle);		//switching to parent window
        driver.quit();								//closing the browser
    }

 public static void main(String[] args) throws IOException {
     multipleWindows win = new multipleWindows();					//creating object 'win'
     	win.createDriver();		//calling createDriver function
         win.validatePage();					//calling validatePage function
         win.totalLinks();					//calling totalLinks function
         win.windowsHandling();				//calling windowsHandling function
     }
     
     
 }
