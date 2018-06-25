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
	public ValidatableResponse getAllGists()
	{
		
		response = steps.getAllGists();
		return response;
	}
	
	
	@When("^the user requests the gist with id (.*)$")
	public ValidatableResponse getAGist(String gistId)
	{
		response = steps.getSpecificGist(gistId);
		return response;
	}
	
	
	@When("^the user requests all gists from user with userId (.*)$")
	public ValidatableResponse getAllGistsFromUser(String userId)
	{
		response=steps.getGistsFromUser(userId);
		return response;
	}
	
	@When("^the user requests all starred gists$")
	public ValidatableResponse getAllstarredGists()
	{
		response = steps.getStarredGists();
		return response;
	}
	
	@When("^the user stars the gist with id (.*)$")
	public ValidatableResponse userStarsAGist(String gistId)
	{
		response = steps.starAGist(gistId);
		return response;
		
	}
	
	@When("^the user checks if the gist with id (.*) is starred$")
	public ValidatableResponse userChecksIfGistStarred(String gistId)
	{
		response = steps.checkIfGistStarred(gistId);
		return response;
	}

	@When("^the user unstars the gist with id (.*)$")
	public ValidatableResponse userUnstarsGist(String gistId)
	{
		response = steps.unstarAGist(gistId);
		return response;
	}
	
	
	@When("^the user forks the gist with id (.*)$")
	public ValidatableResponse userForksAGist(String gistId)
	{
		response = steps.forkAGist(gistId);
		return response;
		
	}
	
	@When("^the user gets all forks for the gist with id (.*) gets a 200 response$")
	public ValidatableResponse userGetsAllForksForAGist(String gistId)
	{
		
		response = steps.getAllForksForGist(gistId);
		return response;
	}
	
	
	@Then("^the list of gists is retrieved with userId (.*)$")
	public void retrieveListOfGists(String userId)
	{
		
		System.out.println("user has the following gists"+steps.getListOfGists(userId));
	}
	
	
	@When("^the user deletes a gist with Id (.*)$")
	public ValidatableResponse userDeletesAGist(String gistId)
	{
		
		response = steps.deleteGist(gistId).assertThat();
		return response;
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
	
	@When("^the user requests the commits for the gist with id (.*)$")
	public ValidatableResponse userGetsGistCommits(String gistId)
	{
		response = steps.getAllCommitsForGist(gistId);
		
		return response;
		
		
	}
	
}
