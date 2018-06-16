package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.w2a.base.Page;



public class LoginPage extends Page{
	
	
	public DashboardPage doLogin(String username, String password) throws InterruptedException
	{
		//driver.get(config.getProperty("recruit_tool_url"));
		driver.get("http://recruit-dev.hiqconsulting.org");
		Thread.sleep(5000);
		waitForElement("RTlogin_CSS");
		type("RTlogin_CSS", username);
		type("RTpassword_CSS", password);
		click("RTloginbtn_CSS");
		Reporter.log("<br> Admin login executed </br>");
		
		return new DashboardPage();
	}

}
