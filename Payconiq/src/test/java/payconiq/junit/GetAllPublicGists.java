package payconiq.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;


@RunWith(SerenityRunner.class)
public class GetAllPublicGists {
	
	

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://api.github.com";
	}
	
	@Test
	public void getAllGists()
	{
		SerenityRest.given()
		.when()
		.get("/gists")
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}

	


