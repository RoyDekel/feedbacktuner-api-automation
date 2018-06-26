package feedbacktunertests.infra;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;

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
	
	/**
	 * Constructor with only @param contentType
	 */ 
	public BaseRequests(ContentType contentType) {
		setRequestParams();
		buildRequest.setContentType(contentType);
	}
	
	/**
	 * Constructor with only @param body
	 */
	public BaseRequests(String body) {
		setRequestParams();
		buildRequest.setBody(body);
	 }
	
	/**
	 * @param contentType
	 * @param body
	 * Constructor with parameters
	 */
	public BaseRequests(ContentType contentType, String body) {
		setRequestParams();
		buildRequest.setContentType(contentType);
	    buildRequest.setBody(body);
	 }
	
	/**
	 * @param URL
	 * @return Response of the GET request
	 */
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
	
	/**
	 * @param URL
	 * @return Response of the PUT request
	 */
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
