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

public class myJson {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String username;
		String password;
		String root = "Casey";
		
		System.out.println("Please enter your Username");
		username = scanner.next();
		
		System.out.println("Please enter your Password");
		password = scanner.next();
		
		happyJson(username, password, root);
		
		//nasty path
		//nastyJson(username, password, root);
		
	}

//nasty path
public static void nastyJson(String username, String password, String root){
		
		//create a JSON object
		JSONObject cred = new JSONObject();
		
		//Add String keys and value pairs, which are my variables that hold user input
		cred.put("password", password);
		cred.put("username", username);
		
		//create a JSON Array and add the object cred with its key values to it
		JSONArray security = new JSONArray();
		security.add(cred);
		
		//nasty path
		//add array to the cred object: because the array has already added the cred object, cred object cannot add the array
		cred.put("security", security);

		//prints out json contents
		System.out.println(cred.toString());
	}

//happy path
public static void happyJson(String username, String password, String root){
	
			//Create a JSON object
			JSONObject credential = new JSONObject();
			
			//add key value pairs to credential object
			credential.put("root", root);
			
			//create a JSON object
			JSONObject cred = new JSONObject();
			
			//Add String keys and value pairs, which are my variables that hold user input
			cred.put("password", password);
			cred.put("username", username);
			
			//create a JSON Array and add the object cred with its key values to it
			JSONArray security = new JSONArray();
			security.add(cred);
			
			//add array to the credential object
			credential.put("security", security);

			//prints out json contents
			System.out.println(credential.toString());
			
			//create file to hold JSON
			createFile(credential, security);
			
}

public static void createFile(JSONObject credential, JSONArray security){
	Scanner scanner = new Scanner(System.in);
	//create a file
	File file = new File("confidential.json");
	
	//nasty path: won't write anything to the file
	try {
		PrintWriter write = new PrintWriter(file);
		write.print(credential.toString());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//happy path: Will write to the file with paranthesis around it
	try (PrintWriter write = new PrintWriter(file)){
		write.print(credential.toJSONString());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	/*
	//happy path: You have to close the printwriter for it to write to the file otherwise it won't
	try {
		PrintWriter write = new PrintWriter(file);
		write.print(credential.toString());
		write.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
	    //pause the execution
		System.out.println("File created successfully, Hit Return to display");
		scanner.nextLine();
		readFile(file, security);
}

public static void readFile(File file, JSONArray security){
	Scanner scanner = new Scanner(System.in);
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
		
		//nasty path: will print out null
		//String user = (String) jsonObj.get("username");
		//System.out.print(user);
		
		System.out.printf("Here we go!!! %s", objsecure.get("root").toString());
		
		//nasty path does not work have to call the root object
		//   System.out.printf("Here we go!!! %s", objsecure.get("username").toString());
		
		//cycle through the array
		JSONArray myArray = (JSONArray) objsecure.get("security");
		JSONObject test = (JSONObject) myArray.get(0);
		String user = (String) test.get("username");
		System.out.printf("Here we go!!! %s", user);
		
		for (int i = 0; i < myArray.size(); i++){
			JSONObject myArray2 = (JSONObject) myArray.get(i);
			String usernamein = (String) myArray2.get("username");
			String passwordin = (String) myArray2.get("password");
			System.out.printf("Username %s%s", usernamein, passwordin);
		}
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

