package com.ravi.AppiumDemo;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.deviceorientation.DeviceOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.collect.ImmutableMap;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic {

	
	@Test
	public void appiumDemo() throws MalformedURLException, InterruptedException
	{
		
		
//		AppiumServiceBuilder service= new AppiumServiceBuilder();
//		service.withAppiumJS(new File("C://Users//nsivarat//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"));
//		service.withIPAddress("127.0.0.1:").usingPort(4723).build();
		
		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("Pixel 2 XL API 29");
		options.setApp("C://Users//nsivarat//eclipse-workspace//AppiumDemo//src//test//java//Resources//ApiDemos-debug.apk");
	
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actual=driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(actual, "WiFi settings");
		driver.setClipboardText("ravi wifi");
	driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	Thread.sleep(5000);
		driver.findElement(By.id("android:id/button1")).click(); 
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		//--> extract text 
		
//		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
//		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
//	WebElement ele=	driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//		
//	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//		    "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
//		));
//	Thread.sleep(2000); ----> long press
		
		
		
	
	
//	driver.findElement(AppiumBy.accessibilityId("Views")).click();
//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
//	---> scroll 
		
		
//		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Gallery']")).click();
//		DeviceRotation rotation= new DeviceRotation(0, 0, 270);
//		driver.rotate(rotation);
//		
//		
//		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
//		WebElement ele = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
//		org.testng.Assert.assertEquals(ele.getAttribute("focusable"), "true");
//		
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement) ele).getId(),
//			    "direction", "left",
//			    "percent", 0.75
//			));
//		org.testng.Assert.assertEquals(ele.getAttribute("focusable"), "false");
//		
//		WebElement ele2 = driver.findElement(By.xpath("(//android.widget.ImageView)[2]"));
//		
//		org.testng.Assert.assertEquals(ele2.getAttribute("focusable"), "true");
//		
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement) ele2).getId(),
//			    "direction", "left",
//			    "percent", 0.75
//			));
//		
//WebElement ele3 = driver.findElement(By.xpath("(//android.widget.ImageView)[3]"));
//		
//		org.testng.Assert.assertEquals(ele3.getAttribute("focusable"), "true");
//		
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement) ele3).getId(),
//			    "direction", "left",
//			    "percent", 0.75
//			));
//		
//WebElement ele4 = driver.findElement(By.xpath("(//android.widget.ImageView)[4]"));
//		
//	
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId", ((RemoteWebElement) ele4).getId(),
//			    "direction", "left",
//			    "percent", 0.75
//			));
//	
//	
//			
//		ele3.click();
//		ele2.click();
//		ele.click(); --> screen rotate
		
		//org.testng.Assert.assertEquals(ele4.getAttribute("focusable"), "false");
		//org.testng.Assert.assertEquals(ele3.getAttribute("focusable"), "true");
		
		}
	
}
