package payconiq.cucumber.steps;

import org.json.simple.JSONObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.authentication.OAuthSignature;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import payconiq.cucumber.serenity.GistsSteps;

public class GistCucumberSteps {
	
	@Steps
	GistsSteps steps;
	String userId;
	String gistId;
	private ValidatableResponse response;
	
	
	
	
	@When("^the user requests all gists$")
	public void getAllGists()
	{
		
		steps.getAllGists().statusCode(200);
	}
	
	
	@When("^the user requests the gist with id (.*) gets a 200ok response$")
	public void getAGist(String gistId)
	{
		steps.getSpecificGist(gistId).statusCode(200);
	}
	
	
	@When("^the user requests all gists from user with userId (.*) gets a 200ok response$")
	public void getAllGistsFromUser(String userId)
	{
		steps.getGistsFromUser(userId).statusCode(200);
	}
	
	@When("^the user requests all starred gists$")
	public void getAllstarredGists()
	{
		steps.getStarredGists().statusCode(200);
	}
	
	@When("^the user stars the gist with id (.*) gets a 200ok response$")
	public void userStarsAGist(String gistId)
	{
		steps.starAGist(gistId).statusCode(204);
		
	}
	
	@When("^the user checks if the gist with id (.*) is starred gets a 204 response$")
	public void userChecksIfGistStarred(String gistId)
	{
		steps.checkIfGistStarred(gistId).statusCode(204);
	}

	@When("^the user unstars the gist with id (.*) gets a 204 response$")
	public void userUnstarsGist(String gistId)
	{
		steps.unstarAGist(gistId).statusCode(204);
	}
	
	
	@When("^the user forks the gist with id (.*) gets a 201 response$")
	public void userForksAGist(String gistId)
	{
		steps.forkAGist(gistId).statusCode(201);
		
	}
	
	@When("^the user gets all forks for the gist with id (.*) gets a 200 response$")
	public void userGetsAllForksForAGist(String gistId)
	{
		
		steps.getAllForksForGist(gistId).statusCode(200);
	}
	
	
	@Then("^the list of gists is retrieved with userId (.*)$")
	public void retrieveListOfGists(String userId)
	{
		
		System.out.println("user has the following gists"+steps.getListOfGists(userId));
	}
	
	
	@When("^the user deletes a gist with Id (.*) gets a 204 response$")
	public void userDeletesAGist(String gistId)
	{
		
		steps.deleteGist(gistId).assertThat().statusCode(204);
	}
	
	@Then("^the status code is (.*)$")
	public void checkStatus(int status)
	{
		
		response.assertThat().statusCode(status);
		
	}
	
	@When("^the user creates a gist with description (.*), isPublic set (.*), file name (.*) and content (.*)$")
	public ValidatableResponse userCreatesAGist(String description, boolean isPublic, String fileName, String content)
	{
		response = steps.createGist(description, isPublic, fileName, content).log().all();
		gistId=response.extract().path("id");
		return response;
		
	}
	
	@Then("^the user updates that gist with description (.*), new name (.*), new file name (.*) and content (.*)$")
	public ValidatableResponse userEditsAGist(String newDescription, String newName, String newFileName, String newContent)
	{
		response = steps.editGist(newDescription, newName, newFileName, newContent, gistId).log().all();
		
		return response;
		
		
	}
	
	@Then("^the user reads that gist$")
	public ValidatableResponse userReadsCurrentGist()
	{
		response = steps.getSpecificGist(gistId).log().all();
		return response;
	}
	
	@Then("^the user deletes that gist$")
	public ValidatableResponse userDeletesCurrentGist()
	{
		
		response = steps.deleteGist(gistId).log().all();
		return response;
	}
	
	
}
