package demo.authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class TokenBasedAuthetication {
	
	static String token;
	@BeforeClass
	public void init() {
		baseURI="http://192.168.4.94:8081/school-attendance-system-test";
		
	}
	
	@Test
	public void test_Login() {
		JSONObject request = new JSONObject();
		
		request.put("username", "admin");
		request.put("password", "admin");
		
		Response  response =given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request).
		when().
			post("/login");
		
		token = response.getBody().jsonPath().getString("token");
		System.out.println(token);
		
		
		
	}
	
	@Test
	public void test_getAllStaff() {
		given().
			accept(ContentType.JSON).
			queryParam("withFace", "false").
			header("Authorization","Bearer "+token).
		when().
			get("/school/1/staffs").
		then().
			statusCode(200).
			body("staffs.name",hasItem("Babu Apu Kumar Barua"));
			
	}

}
