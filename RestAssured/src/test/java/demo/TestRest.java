package demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.provider.ExcelDataProvider;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestRest extends ExcelDataProvider {
	
	@BeforeClass
	public void init(){
		baseURI="https://reqres.in/";
	}
//	@Test
	public void testPost_01() {
		System.out.println("hello");
	}
	
//	@Test(dataProvider = "ExcelData")
	public void testPost_02(String name, String roll) {
		System.out.println("Name:"+name);
		System.out.println("Roll:"+roll);
	}
	
	
//	@Test
	public void testGet_03() {
		baseURI="https://reqres.in/";
		
		given().
			contentType(ContentType.JSON).
		when().
			get("/api/users?page=2").
		then().
			statusCode(200).
			body("data.first_name",hasItems("Michael","Lindsay"));
	}
	
	
	@Test
	public void testPost() {
		JSONObject request = new JSONObject();
		request.put("name", "sanaul");
		request.put("job", "teacher");
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request).
		when().
			post("/api/users").
		then().
			statusCode(201);
	}
}
