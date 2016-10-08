package JSON_QCJSON;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONExercise {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Student name: ");
		
		String name = input.nextLine();
		
		System.out.print("Enter course name: ");
		String course1 = input.nextLine();
		
		System.out.print("Enter Grade: ");
		int grade1 = input.nextInt();
		
		JSONObject root = new JSONObject();
		
		root.put("name", name);
		
		JSONObject courseObject1 = new JSONObject();
		courseObject1.put("grade", grade1);
		courseObject1.put("name", course1);
		
		JSONArray courses = new JSONArray();
		courses.add(courseObject1);
		
		root.put("courses", courses);
		
		System.out.println(root.toJSONString());
		
		File file = new File("test.txt");
		
		try (PrintWriter writer = new PrintWriter(file)){
			writer.print(root.toJSONString());
		} catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
		}

		System.out.println("File created successfully\n\n Hit Return to display");
		input.nextLine();
		
		try {
			input = new Scanner(file);
			StringBuilder jsonIn = new StringBuilder();
			while (input.hasNextLine()){
				jsonIn.append(input.nextLine());
			}
			System.out.println(jsonIn.toString());
			
			JSONParser parser = new JSONParser();
			
			JSONObject objRoot = (JSONObject) parser.parse(jsonIn.toString());
			
			System.out.printf("Student name is %s", objRoot.get("name").toString());
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
		} catch (ParseException ex) {
			System.out.println(ex.toString());
		}
		

	}

}
