package com.miniProject;
import java.util.Scanner;

//importing packages
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverSetup {
	public static WebDriver driver;
    static Scanner sc = new Scanner(System.in);

	
	//method for getting web driver based on browser type
	public static WebDriver getWebDriver() {
		  System.out.println("Enter the browser type (chrome/firefox/edge):");
		  String browserType=sc.nextLine();

		if(browserType.equalsIgnoreCase("chrome")) {		//checking given browser type with 'chrome'
			WebDriverManager.chromedriver().setup();		//setting up Chrome driver using WebDriverManager
			driver = new ChromeDriver();					//initializing ChromeDriver instance
		}
		else if(browserType.equalsIgnoreCase("firefox")) {		//checking given browser type with 'firefox'
			WebDriverManager.firefoxdriver().setup();			//setting up firefox driver using WebDriverManager
			driver = new FirefoxDriver();						//initializing FirefoxDriver instance
		}
		else if(browserType.equalsIgnoreCase("edge")) {		//checking given browser type with 'firefox'
			WebDriverManager.edgedriver().setup();			//setting up edge driver using WebDriverManager
			driver = new EdgeDriver();						//initializing EdgeDriver instance
		}
		else {
			System.out.println("Invalid browser type: " + browserType);		//Printing an error message
		}
		return driver;								//return the driver instance
	}
}
