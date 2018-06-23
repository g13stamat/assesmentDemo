package payconiq.junit;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import payconiq.cucumber.serenity.GistsSteps;
import payconiq.testbase.TestBase;
import payconiq.utils.ReusableSpecifications;


@RunWith(SerenityRunner.class)
public class CreateSecondGist  extends TestBase{
	
	
	@Steps
	GistsSteps steps;

	@Title("This test will create a second gist")
	@Test
	public void createSecondGist()
	{
		
		
		steps.createGistOPT("new gistOPT", true, "fileGist1.txt", "some demo text").log().all().statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
		
		
	}

}

	


