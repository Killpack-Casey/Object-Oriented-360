package JSON_QCJSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


//nasty path with the things I'm using
//import org.json.simple.JSONOBJECT;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//nasty path I found when you type two words in for one variable input, it dissallows you to put in the password it makes the last
// word your password and the first word the username in a key pair

public class example {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		
		System.out.println("Please enter your Username");
		String username1 = scanner.nextLine();
		
		System.out.println("Please enter your Password");
		String password1 = scanner.nextLine();

			JSONObject credential = new JSONObject();
			
			//add key value pairs to credential object
			credential.put("root", username1);
			
			//create a JSON object
			JSONObject cred = new JSONObject();
			
			//Add String keys and value pairs, which are my variables that hold user input
			cred.put("password", password1);
			cred.put("username", username1);
			
			//create a JSON Array and add the object cred with its key values to it
			JSONArray security = new JSONArray();
			security.add(cred);
			
			//add array to the credential object
			credential.put("security", security);

			//prints out json contents
			System.out.println(credential.toString());

	//create a file
	File file = new File("confidential.txt");
	
	//happy path: Will write to the file with paranthesis around it
	try (PrintWriter write = new PrintWriter(file)){
		write.print(credential.toJSONString());
	} catch (FileNotFoundException ex) {
		System.out.println(ex.toString());
	}
	
	    //pause the execution
		System.out.println("File created successfully, Hit Return to display");
		scanner.nextLine();
	
	//read the file

	//reads the file
	//reading the file not from the console anymore
	try {
		scanner = new Scanner(file);
		//A String Builder allows a string to append to an existing one or insert into one
		StringBuilder build = new StringBuilder();
		//only has one line in the file created but has next line just in case so whole file is read
		while (scanner.hasNextLine()){
			build.append(scanner.nextLine());
		}
		System.out.println(build.toString());
		
		//parse json string
		JSONParser myParse = new JSONParser();
		
		JSONObject objsecure = (JSONObject) myParse.parse(build.toString());
		
		System.out.printf("Here we go!!! %s", objsecure.get("root").toString());
		
		//nasty path does not work have to call the root object
	//   System.out.printf("Here we go!!! %s", objsecure.get("username").toString());
		
	
	} catch (FileNotFoundException e) {
		System.out.println(e.toString());
	} catch (ParseException e) {
		System.out.println(e.toString());
	}

}}

