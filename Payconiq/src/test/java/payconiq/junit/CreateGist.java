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
import payconiq.testbase.TestBase;


@RunWith(SerenityRunner.class)
public class CreateGist  extends TestBase{
	
	
	
	
	@Test
	public void getAllGists()
	{
		
		JSONObject newGist = new JSONObject();
		newGist.put("description", "Description text for demo  gist");
		newGist.put("public", true);
		
		
		
		JSONObject newFile = new JSONObject();
		
		
		JSONObject newContent = new JSONObject();
		
		newContent.put("content", "The text that demo file contains");
		newFile.put("file1.txt",newContent);
		newGist.put("files", newFile);
		
		String myToken="9996cb1ace59254f8e902002bb518b627e7584f8";
		
		
		
		
		SerenityRest.given()
		.auth()
		.oauth2(myToken, OAuthSignature.HEADER)
		.when()
		.body(newGist)
		.post("/gists")
		.then()
		.log()
		.all()
		.statusCode(201);
	}

}

	


