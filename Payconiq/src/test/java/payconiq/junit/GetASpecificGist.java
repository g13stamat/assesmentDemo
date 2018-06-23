package payconiq.junit;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;


@RunWith(SerenityRunner.class)
public class GetASpecificGist {
	
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test
	public void getAllGists()
	{
		String gistId="41105f52c05abe426a22b052c1032274";
		
		SerenityRest.given()
		.when()
		.get("/gists/"+gistId)
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
