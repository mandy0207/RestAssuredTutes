package mylearning;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.UniqueGenerators;
import io.restassured.RestAssured;
import pojo.Book;

public class SerializationTest {

	
	@Test
	public void addBookSerialization() {
		
		Book book = new Book("Automation Learning", UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber()), "Vinod");
		RestAssured.baseURI="http://216.10.245.166";
		
		
		String response = given().log().all().header("Content-Type", "application/json").body(book)
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();
		
		
		
		
		
		
	}
	

}
