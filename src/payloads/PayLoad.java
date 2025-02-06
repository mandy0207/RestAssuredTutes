package payloads;

public class PayLoad {

	  public static String getAddBookPayLoad(String isbn, String aisle) {
	        return "{\n" +
	                "  \"name\": \"Automation Learning With Obsqura\",\n" +
	                "  \"isbn\": \"" + isbn + "\",\n" +
	                "  \"aisle\": \"" + aisle + "\",\n" +
	                "  \"author\": \"Sugesh & Vinod\"\n" +
	                "}";
	    }
	  
	  public static String getDeleteBookPayload(String ID) {
		  return "\r\n"
		  		+ " {\r\n"
		  		+ "\"ID\": \""+ID+"\"\r\n"
		  		+ "}";
		  
	  }
}
