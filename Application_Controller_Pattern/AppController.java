package Application_Controller_Pattern;
import java.util.HashMap;
/*
 * The Application Controller is where the processing of the user's input is done.
 */

public class AppController {
	//create a hash map
	public static HashMap<Integer, HandleRequest> bankHashMap = new HashMap<Integer, HandleRequest>();
	
	//default constructor of the class
	public void AppController() {

	}
	
	//method that is called from the application that holds a hash map with keys and their corresponding values
	public static void processRequest(int bankNumber){
		
		//adding to hash map
		bankHashMap.put(1, new yourBank());
		bankHashMap.put(2, new bestBank());
		bankHashMap.put(3, new moneyBank());
		
		//create instance of the handle request interface store the bank number selected by the user to be processed by the 
		//handle request interface
		HandleRequest request = bankHashMap.get(bankNumber);
		
		//execute the bank number 
		request.execute(bankNumber);
	}

}
