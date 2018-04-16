package feedbacktunertests.infra;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseRequests extends BaseAPI {

	public RequestSpecification requestSpec;
	public RequestSpecBuilder buildRequest;
	public ResponseSpecification responseSpec;
	public ResponseSpecBuilder buildResponse;
	
	public void setRequestParams() {
		buildRequest = new RequestSpecBuilder()
				.addCookie(getCookieAfterLogin())
				.addFilter(new ResponseLoggingFilter())
				.addFilter(new RequestLoggingFilter());
		requestSpec = buildRequest.build();
		buildResponse = new ResponseSpecBuilder();
		buildResponse.expectStatusCode(200);
		responseSpec = buildResponse.build();
	}
	
	public BaseRequests() {
		setRequestParams();
	}
	
	public BaseRequests(ContentType contentType) {
		setRequestParams();
		buildRequest.setContentType(contentType);
	}
	
	public BaseRequests(String body) {
		setRequestParams();
		buildRequest.setBody(body);
	 }
	
	public BaseRequests(ContentType contentType, String body) {
		setRequestParams();
		buildRequest.setContentType(contentType);
	    buildRequest.setBody(body);
	 }
	
	public Response getRequest(String URL) {
		return response = given()
				.spec(requestSpec)
				.when()
				.get(getBaseURI() + URL)
				.then()
				.spec(responseSpec)
				.extract()
				.response();
	}
	
	public Response putRequest(String URL) {
		return response = given()
				.spec(requestSpec)
				.when()
				.put(getBaseURI() + URL)
				.then()
				.spec(responseSpec)
				.extract()
				.response();
	}
}
