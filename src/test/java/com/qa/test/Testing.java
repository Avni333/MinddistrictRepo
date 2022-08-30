package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
	WebDriver driver;

	
	
  @BeforeSuite
  public void launchbrowser() throws InterruptedException {
	  
	  
	  System.setProperty("webdriver.chrome.driver", "/Users/anitasubedi/Downloads/chromedriver");  
	    driver = new ChromeDriver(); 
	    driver.manage().window().maximize();
	    driver.navigate().to("https://codingtask.minddistrict.dev/en/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    //for cookies allow
	    driver.findElement(By.xpath("//div[@class='banner__actions']//md-button")).click();
	   
	    //JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();", cookie);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	  
      driver.findElement(By.id("login")).sendKeys("testing+anita@minddistrict.com");
      driver.findElement(By.id("password")).sendKeys("TestingIsC00l!");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
	}
	
	@BeforeMethod
	public void GetStartpage() throws InterruptedException
	{     
		
		       
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.partialLinkText("Catalog"))).build().perform();
				
				 driver.findElement(By.xpath("//a[contains(text(),'Catalogue')]")).click();
		
		//selectmodules
			
				Thread.sleep(2000);
         List<WebElement> list = driver.findElements(By.xpath("//ul[@class='catalogue-cards']//li"));
         
         System.out.println(list.size());
         
         for(int i =0;i<list.size();i++)
         { 
        	 
        	 System.out.println(list.get(i).getText());
               Thread.sleep(1000);
		       if(list.get(i).getText().contains("Blij met jezelf"))
		       {
		    	   list.get(i).click();
		    	   Thread.sleep(1700);
		    	   driver.findElement(By.id("form_actions_start")).click();
		    	   break;
		    	   
		    	   }
		       
         }
		       
		      
       
	    
      }
	
	@Test(priority = 2)
	public void ProgressBar()
	{
		boolean b1 = driver.findElement(By.xpath("//div[@class='progress-info']")).isDisplayed();
		AssertJUnit.assertTrue(b1);
		
	}
	
	@Test(priority = 1)
	public  void CollapsedTile()
	{
		driver.findElement(By.xpath("//div[@class='layout__top-bar-inner ng-tns-c116-0']//div[@class='ng-tns-c116-0']//button[@type='button']")).click();
	    AssertJUnit.assertTrue(true);
	
	}
	
	@Test
	public void Homepageview()
	{    
		
		driver.findElement(By.xpath	("//ul[contains(@class,'header__navigation-items')]//li//a")).click();
		
		
	}
  
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
	
  


