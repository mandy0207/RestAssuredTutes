package learnParsingJson;

import java.util.List;

import org.testng.annotations.Test;

import Utils.ParseJson;
import payloads.PayLoad;

public class LearnJsonParsing {

	@Test
	public void parsing() {
		
		String booksPayload=PayLoad.getDummyJsonOfBooks();
		List<String> booksName = ParseJson.getJsonPathObject(booksPayload).getList("book_name");
		List<String> authorsName = ParseJson.getJsonPathObject(booksPayload).getList("author");
		System.out.println(booksName);
		System.out.println(authorsName.get(1));
	}

}
