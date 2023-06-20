package com.ravi.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserTesting {

	
	@Test
	public void signin() throws MalformedURLException, InterruptedException
	{
		
		
		
UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("Pixel 2 XL API 29");
		options.setChromedriverExecutable("C://Users//nsivarat//Downloads//chromedriver_win32 (1)//chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://swqe4.test.subway.com/en-ca");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement pro = driver.findElement(By.cssSelector(".account_logged"));
		Thread.sleep(5000);
		pro.click();


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInName"))).sendKeys("Rolexenca@qasubway.com");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Subway@123");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();

		Actions action = new Actions(driver);
		WebElement b = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("START ORDER"))));

		try {
			b.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", b);
		}

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderType")));

		String title1 = driver.getTitle();
		
		if (title1.equals("Menu | Subway®")) {

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("[onclick='analytics.defaultStoreHeader();']"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'PICK UP HERE')]")));
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.cssSelector("[class='pickupCtaButton']")))).click();

			driver.switchTo().activeElement();
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("(//*[contains(text(),'Curbside')])[2]"))))
					.click();

		} else {

			WebElement t = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='searchLocationInput']")));

			t.sendKeys("#32256" + Keys.ENTER);
			t.sendKeys(Keys.ENTER);
			// t.sendKeys( Keys.ENTER);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'PICK UP HERE')]")));
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.cssSelector("[class='pickupCtaButton']")))).click();

			driver.switchTo().activeElement();
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("(//*[contains(text(),'Curbside')])[2]"))))
					.click();

		}

		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Subway® Series')]")));

//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Subway® Series')]"))).click();

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Subway® Series')]")))
					.click();

		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", By.xpath("//*[contains(text(),'Subway® Series')]"));
		}

		Thread.sleep(500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='card__title']"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testauto-id=pdp-add-to-cart]")))
				.click();

		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testauto-id=close-Modal-btn]")))
				.click();

		Thread.sleep(6000);
		WebElement ele = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("[class='badge-bagcount totalCartQuantity']")));

		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(5000);
				ele.click();

				break;
			} catch (StaleElementReferenceException e) {

			}

		}

		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testauto-id='order-checkout']")))
				.click();

		Thread.sleep(500);

//WebElement r = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Credit/Debit')]")));
//r.click(); 

		driver.switchTo().activeElement();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testauto-id='Motorcycle']")))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testauto-id='Green']"))).click();
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testauto-id='continuePayment-btn']")))
				.click();

		WebElement se = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),' PLACE ORDER ')]")));

		try {
			se.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", se);
		}

	}
	
	
	
	
}
