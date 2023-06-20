package com.ravi.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class NativeApkDemo {

	
	@Test
	public void ecommerce() throws MalformedURLException, InterruptedException
	{
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("Pixel 2 XL API 29");
		options.setApp("C://Users//nsivarat//Downloads//General-Store.apk");
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ravi");
		
		driver.hideKeyboard();
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
//		String s=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//		Assert.assertEquals(s, "Please enter your name");  --> toast notification
		
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		
		int siz=driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();	
		
		String price="";
		String st1="";
		for(int i=0; i<=siz-1; i++)
		{
			String st=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(st.equalsIgnoreCase("Jordan 6 Rings"))
			{
				
				st1=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				 price=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
		}
			
		}
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click();
		
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String productname=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		Assert.assertEquals(productname, st1);		
		
		String productprice=driver.findElement(By.id("com.androidsample.generalstore:id/productPrice")).getText();
		Assert.assertEquals(productprice, price);
		
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
}
	
	
	
}
