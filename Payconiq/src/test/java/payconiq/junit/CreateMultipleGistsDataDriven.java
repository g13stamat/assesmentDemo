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
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import payconiq.cucumber.serenity.GistsSteps;
import payconiq.testbase.TestBase;
import payconiq.utils.ReusableSpecifications;


@UseTestDataFrom("testdata/studentInfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateMultipleGistsDataDriven  extends TestBase{
	
	private static String description;
	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		CreateMultipleGistsDataDriven.description = description;
	}

	public static boolean isPublic() {
		return isPublic;
	}

	public static void setPublic(boolean isPublic) {
		CreateMultipleGistsDataDriven.isPublic = isPublic;
	}

	public static String getFilename() {
		return filename;
	}

	public static void setFilename(String filename) {
		CreateMultipleGistsDataDriven.filename = filename;
	}

	public static String getContent() {
		return content;
	}

	public static void setContent(String content) {
		CreateMultipleGistsDataDriven.content = content;
	}

	private static boolean isPublic;
	private static String filename;
	private static String content;
	
	
	
	@Steps
	GistsSteps steps;
	
	@Title("This test will create multile data driven gists")
	@Test
	public void createSecondGist()
	{
		
		
		steps.createGistOPT(description, isPublic, filename, content).log().all().statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
		
		
	}

}

	


