package mylearning;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Utils.UniqueGenerators;
import io.restassured.RestAssured;
import pojo.Book;

public class SerializationTest {

	
	@Test
	public void addBook() {
		
		Book book = new Book("Automation Learning", UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber()), "Vinod");
		RestAssured.baseURI="http://216.10.245.166";
		
		
		String response = given().log().all().header("Content-Type", "application/json").body(book)
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();
	}
}
