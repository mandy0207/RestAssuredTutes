package mylearning;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.ParseJson;
import Utils.UniqueGenerators;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.PayLoad;
public class LibraryAPI {

	
	
	@Test(priority=0)
	public void verifyUserIsAbleToAddBooks() {
		
		RestAssured.baseURI="http://216.10.245.166";
		//Creating a Book
		String response = given().log().all().header("Content-Type", "application/json").body(PayLoad.getAddBookPayLoad(UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber())))
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		
		String BookID=js.get("ID");
		System.out.println(BookID);

		//fECTHING A bOOK
		String bookDetail= given().header("Content-Type", "application/json").queryParam("ID", BookID)
		.when().get("/Library/GetBook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();	
		
		
		List<String> isbn = ParseJson.getJsonPathObject(bookDetail).getList("isbn");
		List<String> aisle = ParseJson.getJsonPathObject(bookDetail).getList("aisle");
	    String aisleNumber= aisle.get(0);
	    String isbnNumber= isbn.get(0);
	    
	    String actualID= isbnNumber+aisleNumber;
	    
	    
	    //TestNG Assertion
	    Assert.assertEquals(actualID, BookID);
		
		//DELETE Call
		given().header("Content-Type", "application/json").body(PayLoad.getDeleteBookPayload(BookID)).when().delete("/Library/DeleteBook.php").then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("book is successfully deleted"));
		
		
		
	
	}

}
