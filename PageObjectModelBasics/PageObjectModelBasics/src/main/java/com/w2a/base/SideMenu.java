package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import agap2.nl.pages.CarPage;
import agap2.nl.pages.crm.accounts.AccountsPage;
import agap2.utilities.LoadProperties;

public class SideMenu {
	
	
	Properties config;
	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public Properties getOR() {
		return OR;
	}

	public void setOR(Properties oR) {
		OR = oR;
	}



	Properties  OR ;


	WebDriver driver;
	
	public SideMenu(WebDriver driver)
	{
		this.driver = driver;
		
		
		config = new LoadProperties().loadConfig(System.getProperty("user.dir") + "\\src\\test\\resources\\agap2\\properties\\config.properties");
		OR = new LoadProperties().loadOR(System.getProperty("user.dir") + "\\src\\test\\resources\\agap2\\properties\\OR.properties");
		
	}
	
	public void goToDashboard()
	{
		
	}
	
	
	public void goToCandidates()
	{
		
	}
	
	public void goToAdminUsers()
	{
		
	}
	
	public void goToAdminRoles()
	{
		
	}
	
	public CarPage goToCarReservationCars() throws InterruptedException
	{
	
		
		waitForElement("car_reservation_ID");
		click("car_reservation_ID");
		waitForElement("cars_ID");
		click("cars_ID");
		
		/*	waitForElement("car_reservation_ID");
		click("car_reservation_ID");
		Reporter.log("<br> go to car reservations </br>");
		
		waitForElement("cars_ID");
		click("cars_ID");
		Reporter.log("<br> go to cars </br>");
	*/	
		return new CarPage();
		
	}
	
	public void goToCarReservationReservation()
	{
		
	}
	
	public void searchByName()
	{
		
	}
	
	public void click(String locator) throws InterruptedException {

		// method to click on an element - provide locator
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			Reporter.log("<br> clicking on the " + locator + "</br>");
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			Reporter.log("<br> clicking on the " + locator + "</br>");
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
			Reporter.log("<br> clicking on the " + locator + "</br>");
		}
	}


	public void type(String locator, String input) throws InterruptedException {

		// method for sending keys - provide locator and text to be sent

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(config.getProperty(input));
			Reporter.log("<br> input value " + input + "</br>");
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(config.getProperty(input));
			Reporter.log("<br> input value " + input + "</br>");
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(config.getProperty(input));
			Reporter.log("<br> input value " + input + "</br>");
		}

	}
	
	

	public void waitForElement(String locator) {

		// method for locating elements in CSS XPATH or ID - uses expectedConditions,
		// static waits and retries to locate an element - provide locator
		WebDriverWait elementWait = new WebDriverWait(driver, 10);
		WebElement temp = null;
		int retries = 1;
		if (locator.endsWith("_CSS")) {
			WebElement element = elementWait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OR.getProperty(locator))));

			while (temp == null && retries < 4) {
				try {
					temp = driver.findElement(By.cssSelector(OR.getProperty(locator)));
					System.out.println("trying to locate CCS element " + locator);
					Thread.sleep(1000);

				} catch (Exception ex) {
					Reporter.log("Exception");
				}
				retries++;
				System.out.println("retrying .. " + retries);
			}
		}

		else if (locator.endsWith("_XPATH")) {
			WebElement element = elementWait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty(locator)))));
			while (temp == null && retries < 4) {
				try {
					temp = driver.findElement(By.xpath(OR.getProperty(locator)));
					System.out.println("trying to locate XPATH element " + locator);
					Thread.sleep(1000);

				} catch (Exception ex) {
					Reporter.log("Exception");
				}
				retries++;
				System.out.println("retrying .. " + retries);
			}

		} else if (locator.endsWith("_ID")) {
			WebElement element = elementWait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(OR.getProperty(locator)))));
			while (temp == null && retries < 4) {
				try {
					temp = driver.findElement(By.id(OR.getProperty(locator)));
					System.out.println("trying to locate ID element " + locator);
					Thread.sleep(1000);
				} catch (Exception ex) {
					Reporter.log("Exception");
				}
				retries++;
				System.out.println("retrying .. " + retries);
			}
		}

	}


}
