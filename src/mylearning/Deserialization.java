package mylearning;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import pojo.Book;
import pojo.BookDetail;

public class Deserialization {

	
//	@Test
//	public void deserialTest() throws JsonMappingException, JsonProcessingException {
//		RestAssured.baseURI="http://216.10.245.166";
//		
//		String booksResponse= given().header("Content-Type", "application/json").queryParam("AuthorName", "Obsqura Tutor")
//				.when().get("/Library/GetBook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
//		
//	ObjectMapper maper= new ObjectMapper();
//	BookDetail[] bookArray = maper.readValue(booksResponse, BookDetail[].class);
//	
//	List<BookDetail>books=Arrays.asList(bookArray);
//	
//	for(BookDetail book : books) {
//		System.out.println(book.getBook_name() + " "+ book.getIsbn());	
//	}	
//		
//	}
	
	
	@Test
	public void deserialBestPrcatice() throws JsonMappingException, JsonProcessingException {
		RestAssured.baseURI="http://216.10.245.166";
		
		String booksResponse= given().header("Content-Type", "application/json").queryParam("AuthorName", "Obsqura Tutor")
				.when().get("/Library/GetBook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	ObjectMapper maper= new ObjectMapper();
	Book[] bookArray = maper.readValue(booksResponse, Book[].class);
	
	List<Book>books=Arrays.asList(bookArray);
	
	for(Book book : books) {
		System.out.println(book.getName() + " "+ book.getIsbn());	
	}	
		
	}
}
