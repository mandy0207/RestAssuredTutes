package learnParsingJson;

import org.testng.annotations.Test;

import Utils.ParseJson;
import io.restassured.path.json.JsonPath;
import payloads.PayLoad;

public class ParsingAnotherJson {

	@Test
	public void parsingtest() {
		
		String jsonString=PayLoad.getpracticeJson();
		JsonPath js = ParseJson.getJsonPathObject(jsonString);
		System.out.println(js.getInt("totalDrinks"));
		
		System.out.println(js.getString("offers.Espresso"));
		System.out.println(js.getString("offers.FruitJuice"));
		int numberofItemsInData=js.getInt("data.size()");
		System.out.println(numberofItemsInData);

		int sum=0;
		
		for(int i =0;i<numberofItemsInData;i++) {
			sum= sum+ js.getInt("data["+i+"].price");
		}
		System.out.println(sum);
		
		
//		System.out.println(js.getString("data[0].price"));
//		System.out.println(js.getString("data[1].price"));
		
		
		
		
	}
}
