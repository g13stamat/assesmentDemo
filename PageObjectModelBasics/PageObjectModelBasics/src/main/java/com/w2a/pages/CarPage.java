package com.w2a.pages;


import java.util.Properties;

import com.w2a.base.Page;



public class CarPage extends Page {
	
	
	
	
	
	
	public void searchCar()
	{
		
		
	}
	
	
	public void addNewCar() throws InterruptedException
	{
		
		waitForElement("addnewcarBtn_ID");
		click("addnewcarBtn_ID");
		waitForElement("carDescription_ID");
		type("carDescription_ID", "car_description");
		
		
	}
	
	public void deleteCar()
	{
		
	}
	
	public void gotoReservation()
	{
		menu.goToCarReservationReservation();
		
	}
	
	public void gotoCandidates() throws InterruptedException
	{
		menu.goToCandidates();
		
	}
	
	public void gotoAdminUsers()
	{
		menu.goToAdminUsers();
	}
	
	public void gotoAdminRoles()
	{
		menu.goToAdminRoles();
	}
	
	public void gotoDasboard()
	{
		menu.goToDashboard();
	}
	
	public void logoutUser() throws InterruptedException
	{
		topmenu.logout();
	}
	

}
