package payconiq.cucumber.steps;

import org.json.simple.JSONObject;

import cucumber.api.java.en.When;
import io.restassured.authentication.OAuthSignature;
import net.serenitybdd.rest.SerenityRest;

public class GistCucumberSteps {
	
	
	@When("^the user requests all gists$")
	public void getAllGists()
	{
		SerenityRest.rest()
		.given()
		.when()
		.get("/gists")
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
