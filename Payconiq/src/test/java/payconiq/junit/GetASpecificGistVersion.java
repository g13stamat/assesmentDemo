package payconiq.junit;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;


@RunWith(SerenityRunner.class)
public class GetASpecificGistVersion {
	
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test
	public void getAllGists()
	{
		String gistId="41105f52c05abe426a22b052c1032274";
		String version = "4372b9cfd99509d3aca1b0ff4f46edea393ed0f6";
		
		SerenityRest.given()
		.when()
		.get("/gists/"+gistId+"/"+version)
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
