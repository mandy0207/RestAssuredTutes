package mylearning;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Utils.UniqueGenerators;
import pojo.Book;
import specBuilders.Specs;
public class LibraryAPIWithSpecBuilder {

	
	@Test
	public void verifyUserIsAbleToAddBooks() {
		String baseUri="http://216.10.245.166";
		Book book = new Book("Automation Learning", UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber()), "Vinod");
		
		String response = given().spec(Specs.makeRequestSpec(baseUri)).body(book).post("/Library/Addbook.php")
				.then().spec(Specs.makeResponseSpec()).extract().response().asString();
	    System.out.println(response);
		
	}
	
	
	

}
