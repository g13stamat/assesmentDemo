package com.w2a.testcases;

import org.testng.annotations.Test;

import agap2.nl.pages.DashboardPage;
import agap2.nl.pages.LoginPage;

public class LoginRecruitTool extends BaseTest{
	
	@Test
	public void loginTest() throws InterruptedException
	{
		LoginPageZoho lp = new LoginPageZoho();
		
		DashboardPage dp = lp.doLogin("AdminLogin", "AdminPass");
		
	}

}
