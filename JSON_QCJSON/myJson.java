package JSON_QCJSON;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




//nasty path with the things I'm using
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//nasty path I found when you type two words in for one variable input, it disallows you to put in the password it makes the last
// word your password and the first word the username in a key pair

public class myJson {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//create variables for input
		String username;
		String password;
		String root = "Casey";
		
		//ask user for input
		System.out.println("Please enter your Username");
		username = scanner.next();
		
		System.out.println("Please enter your Password");
		password = scanner.next();
		
		//call method to begin creating some JSON
		happyJson(username, password, root);
		
		//nasty path: calls method to begin creating some JSON
		//nastyJson(username, password, root);
		
	}

//nasty path
public static void nastyJson(String username, String password, String root){
		
		//create a JSON object
		JSONObject branch = new JSONObject();
		
		//Add String keys and value pairs, which are my variables that hold user input to branch object
		branch.put("password", password);
		branch.put("username", username);
		
		//create a JSON Array and add the object branch with its key values to it
		JSONArray array = new JSONArray();
		array.add(branch);
		
		//nasty path
		//add array to the branch object: because the array has already added the branch object, branch object cannot add the array
		branch.put("array", array);

		//prints out json contents
		System.out.println(branch.toString());
	}

//happy path
public static void happyJson(String username, String password, String root){
	
			//Create a JSON object
			JSONObject master = new JSONObject();
			
			//add key value pairs to master object
			master.put("root", root);
			
			//create a JSON object
			JSONObject branch = new JSONObject();
			
			//Add String keys and value pairs, which are my variables that hold user input
			branch.put("password", password);
			branch.put("username", username);
			
			//create a JSON Array and add the object branch with its key values to it
			JSONArray array = new JSONArray();
			array.add(branch);
			
			//add array to the master object
			master.put("array", array);

			System.out.println();
			//prints out json contents
			System.out.println("Prints out JSON after creation");
			System.out.println(master.toString());
			System.out.println();
			
			//create file to hold JSON
			createFile(master, array);
			
}

public static void createFile(JSONObject master, JSONArray array){
	Scanner scanner = new Scanner(System.in);
	
	//create a file, file is saved under workspace/CIT360
	File file = new File("confidential.txt");
	
	//nasty path: won't write anything to the file, you have to close the printwriter for it to write to file
	try {
		PrintWriter write = new PrintWriter(file);
		write.print(master.toString());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//happy path: Will write to the file with paranthesis around it
	try (PrintWriter write = new PrintWriter(file)){
		write.print(master.toJSONString());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	/*
	//happy path: You have to close the printwriter for it to write to the file otherwise it won't
	try {
		PrintWriter write = new PrintWriter(file);
		write.print(master.toString());
		write.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
	    //pause the execution
		System.out.println("File created successfully, Hit Return to display");
		scanner.nextLine();
		readFile(file, array);
}

public static void readFile(File file, JSONArray array){
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
		
		System.out.println("Print contents of StringBuilder");
		System.out.println(build.toString());
		System.out.println();
		
		//parse json string
		// a json parser provides read access to JSON data
		JSONParser myParse = new JSONParser();
		
		//we parse the string using the parser and cast it to a JSON Object
		JSONObject objmaster = (JSONObject) myParse.parse(build.toString());
		
		//nasty path: will print out null because username is a key of an object within an array it can only
		//be accessed through a JSONArray. The object looked for username but did not find it
		//so it returns null
		System.out.println("This is a nasty path");
		String userTest = (String) objmaster.get("username");
		System.out.print(userTest);
		System.out.println();
		
		System.out.println();
		
		//This prints out the value we put in our master object. Because our master object is not buried in an array
		//we can access it's key value pair.
		System.out.printf("Generating username and password for %s", objmaster.get("root").toString());
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println("Print out contents of the objmaster object");
		System.out.println(objmaster.toString());
		System.out.println();
		
		//If we want to access our object that has some of our key value pairs we need to create a new array and with
		//our JSONObject we created before we need to get our array and cast it to a JSONArray to access the values found
		//in it
		JSONArray myArray = (JSONArray) objmaster.get("array");
		
		//with our JSONArray we grab the first element in the array. In this case it is our only element, which was
		//our branch object at creation and we stick the object element in the array into it's own object
		JSONObject test = (JSONObject) myArray.get(0);
		
		//We then create variables to hold our values from our object
		String user = (String) test.get("username");
		String pass = (String) test.get("password");
		
		//prints out the username and password from our branch object we created at creation
		System.out.println("Your username is: " + user);
		System.out.println("Your password is: " + pass);
		
		System.out.println();
		
		//This is just an example of printing out the information from a loop. If there are more than one element in
		//the array we would do this.
		String usernamein = null, passwordin = null;
		for (int i = 0; i < myArray.size(); i++){
			JSONObject branchobj = (JSONObject) myArray.get(i);
			usernamein = (String) branchobj.get("username");
			passwordin = (String) branchobj.get("password");
			
		}
		System.out.println("Your username is: " + usernamein);
		System.out.println("Your password is: " + passwordin);
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

