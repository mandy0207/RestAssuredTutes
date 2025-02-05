package mylearning;

import org.testng.annotations.Test;

import Utils.UniqueGenerators;
import io.restassured.RestAssured;
import payloads.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class LibraryAPI {

	@Test
	public void verifyUserIsAbleToAddBooks() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		given().log().all().header("Content-Type", "application/json").body(PayLoad.getAddBookPayLoad(UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber())))
		.when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added"));
		
		
	}

}
