package com.w2a.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import agap2.nl.base.Page;

public class DashboardPage extends Page {
	
	
	
	//main functionality
	public void verifyTabs()
	{
		String bodyText = driver.findElement(By.tagName("body")).getText();
		System.out.println(bodyText);
		Assert.assertTrue(bodyText.contains("Candidates"));
		Assert.assertTrue(bodyText.contains("Car Reservation"));
		
		
	}
	
	
	public void viewAllCandidates()
	{
		
	}
	
	
	// side and top menu options
	public void gotoCandidates()
	{
		menu.goToCandidates();
		
	}
	
	
	public CarPage gotoCars() throws InterruptedException
	{
		
		menu.goToCarReservationCars();
		
		return new CarPage();
		
		
		
	}
	
	
	public void gotoReservation()
	{
		
		
		
	}
	

}
