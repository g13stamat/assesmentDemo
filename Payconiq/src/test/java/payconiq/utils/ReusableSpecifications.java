package payconiq.utils;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.apache.http.auth.AUTH;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.hibernate.validator.constraints.Length;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.authentication.OAuthSignature;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecifications {
	
	
	public static RequestSpecBuilder requestBuilder;
	public static RequestSpecification requestSpec;
	public static ResponseSpecBuilder responseBuilder;
	public static ResponseSpecification responseSpec;
	
	
	public static RequestSpecification getGenericRequestSpec(String myToken)
	{
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setContentType(ContentType.JSON);
		requestBuilder.setAuth(RestAssured.oauth2(myToken, OAuthSignature.HEADER));
		requestSpec = requestBuilder.build();
		return requestSpec;
	}
	
	
	public static RequestSpecification getContentLengthZeroRequestSpec(String myToken)
	{
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setContentType(ContentType.JSON);
		requestBuilder.addHeader("Content-Length", "0");
		requestBuilder.setAuth(RestAssured.oauth2(myToken, OAuthSignature.HEADER));
		requestSpec = requestBuilder.build();
		return requestSpec;
	}
	
	public static ResponseSpecification getGenericResponseSpec()
	{
		
		responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
//		responseBuilder.expectHeader("Transfer-Encoding", "chunked");
		responseBuilder.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		responseSpec = responseBuilder.build();
		return responseSpec;
		
	}

}
