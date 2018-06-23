package payconiq.cucumber.serenity;

import org.json.simple.JSONObject;

import io.restassured.authentication.OAuthSignature;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import payconiq.utils.ReusableSpecifications;

public class GistsSteps {
	
	private static String myToken = "9996cb1ace59254f8e902002bb518b627e7584f8";
	
	

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

}
