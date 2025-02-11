package mylearning;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PayLoad;

public class GithubOAuth2 {

	static String code="";
	@BeforeTest
	public void grabCode() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/login/oauth/authorize?client_id=Ov23lih8WyHAcF4NB1WP&redirect_uri=http://localhost/callback&scope=repo");
		driver.findElement(By.id("login_field")).sendKeys("vinod543211");
		driver.findElement(By.id("password")).sendKeys("ObsquraTesting24$");
		driver.findElement(By.xpath("//*[@value='Sign in']")).click();
		Thread.sleep(2000);
	    code=driver.getCurrentUrl().split("=")[1];
		driver.quit();
		
	}
	
	
	@Test
	public void learnOAuth() {
		//System.out.println(code);
		
		//getting accessToken
		RestAssured.baseURI="https://github.com";
		String response=given().header("Content-Type", "application/json").body(PayLoad.getGitHubPayload("Ov23lih8WyHAcF4NB1WP", "788f74528af3053d5b87cd5c27e3fc742203d737", code)).
		when().post("/login/oauth/access_token").then().statusCode(200).extract().response().asString();
		String accessToken=response.split("&")[0].split("=")[1];
		System.out.println(accessToken);
		
		
		//getting user info
		String userInfo=RestAssured.baseURI="https://api.github.com";
		given().header("Authorization", "Bearer "+accessToken)
		.when().get("/user").then().log().all().statusCode(200).extract().response().asString();
		

		
	}
}
