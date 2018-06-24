package payconiq.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.authentication.OAuthSignature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import payconiq.utils.ReusableSpecifications;

public class GistsSteps {
	
	private static String myToken = "";
	
	static Response response;
	static String jsonAsString;
	static List<String> gistList;
	
	
	@Step
	public ValidatableResponse createGist(String description, boolean isPublic, String fileName, String content)
	{
		
		JSONObject newGist = new JSONObject();
		newGist.put("description", description);
		newGist.put("public", isPublic);
		JSONObject newFile = new JSONObject();
		JSONObject newContent = new JSONObject();
		newContent.put("content", content);
		newFile.put(fileName,newContent);
		newGist.put("files", newFile);
		
	
		
		
		return SerenityRest.rest().given()
		.auth()
		.oauth2(myToken, OAuthSignature.HEADER)
		.when()
		.body(newGist)
		.post("/gists")
		.then();
			
		
	}
	
	@Step
	public ValidatableResponse editGist(String description, String packageName, String FileName, String content, String gistId)
	{
		
		JSONObject editGist = new JSONObject();
		editGist.put("description", description);
//		newGist.put("public", isPublic);
		JSONObject newFile = new JSONObject();
		JSONObject newFilePackage = new JSONObject();
		newFilePackage.put("filename", FileName);
		newFilePackage.put("content", content);
		
		newFile.put(packageName, newFilePackage);
		editGist.put("files", newFile);
		
		
		
		
		return  SerenityRest.rest().given()
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.body(editGist)
				.patch("/gists/"+gistId)
				.then();
				
	}
	
	
	@Step
	public ValidatableResponse deleteGist(String gistId)
	{
		
		return  SerenityRest.rest().given()
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.delete("/gists/"+gistId)
				.then();
		
	}
	
	@Step
	public ValidatableResponse createGistOPT(String description, boolean isPublic, String fileName, String content)
	{
		
		JSONObject newGist = new JSONObject();
		newGist.put("description", description);
		newGist.put("public", isPublic);
		JSONObject newFile = new JSONObject();
		JSONObject newContent = new JSONObject();
		newContent.put("content", content);
		newFile.put(fileName,newContent);
		newGist.put("files", newFile);
		
	
		
		
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
		.auth()
		.oauth2(myToken, OAuthSignature.HEADER)
		.when()
		.body(newGist)
		.post("/gists")
		.then();
			
		
	}
	
	@Step
	public ValidatableResponse getAllGists()
	{
		
		return  SerenityRest.rest()
				.given()
				.when()
				.get("/gists")
				.then();
		
	}
	
	@Step
	public ValidatableResponse getSpecificGist(String gistId)
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.get("/gists/"+gistId)
				.then();
		
	}
	
	
	@Step
	public ValidatableResponse getGistsFromUser(String userId)
	{
		  
			return SerenityRest.rest()
					.given()
					.when()
					.get("users/"+userId+"/gists")
					.then();
	}
	
	
	@Step
	public ValidatableResponse getStarredGists()
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.get("/gists/starred")
				.then();
		
	}
	
	
	@Step
	public ValidatableResponse starAGist(String gistId)
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.put("/gists/"+gistId+"/star")
				.then();
		
	}
	
	@Step
	public ValidatableResponse checkIfGistStarred(String gistId)
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.get("/gists/"+gistId+"/star")
				.then();
		
	}
	
	@Step
	public ValidatableResponse unstarAGist(String gistId)
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.delete("/gists/"+gistId+"/star")
				.then();
		
	}
	
	
	@Step
	public ValidatableResponse forkAGist(String gistId)
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.post("/gists/"+gistId+"/forks")
				.then();
		
	}
	
	
	@Step
	public ValidatableResponse getAllForksForGist(String gistId)
	{
		
		return  SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec(myToken))
				.auth()
				.oauth2(myToken, OAuthSignature.HEADER)
				.when()
				.get("/gists/"+gistId+"/forks")
				.then();
		
	}
	
	
	@Step
	public List<String> getListOfGists(String userId)
	{
		gistList= SerenityRest.rest()
					.given()
					.when()
					.get("users/"+userId+"/gists")
					.then()
					.log().all()
					.extract()
					.response()
					.path("id");
			  
			  return gistList;
		
	}
	
	
	

}
