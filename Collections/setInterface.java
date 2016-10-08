package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.TabSet;


public class setInterface {

	public static void main(String[] args) {
		
		//Declare an array and a set
		List<String> myArrayList = new ArrayList<String>();
		Set<String> mySet = new HashSet<String>();
		
		//Call the printAnimals method
		printAnimals(myArrayList, mySet);
		
		//Call the testSet method for testing
		testSet(mySet);

	}
	
	//populates an array and set based on user input
	public static void populate (List<String> myArrayList, Set<String> mySet){
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 7; i++){
			System.out.println("Please enter 7 animals");
			String arrayAnimal = scanner.next();
			
			//Bad code when you want duplicate elements stored and displayed
			myArrayList.add(arrayAnimal);
			
			//Good code when you want to display all elements the user inputs to the program even duplicates
			mySet.add(arrayAnimal);
		}
		
	}
	
	//print out all elements added by the user
	public static void printAnimals(List<String> myArrayList, Set<String> mySet){
	
	//Call the populate method first to populate our array and set
	populate(myArrayList, mySet);
		
	System.out.print("From my set:        ");
	for (String loop : mySet){
		System.out.print(loop + " ");
		}
	
	//Formatting, need a new line
	System.out.println();
		
	System.out.print("From my array:      ");
	for (String loop : myArrayList){
		System.out.print(loop + " ");
		}
		
	}
	
	public static void testSet(Set<String> mySet){
		System.out.println();
		
		//nasty path
		//A set has a set size that if exceeded will throw an index out of bounds error
		//mySet.remove(8000000000000000);
		
		//happy path
		mySet.add("Pig");
		
		//nasty path: you must only add values of the same type to the set
		//mySet.add(1);
		
		//nasty path: Sets do not add duplicates, it will only add duplicate values once
		mySet.add("Pig");
		mySet.add("Pig");
		
		System.out.print("From my test set:        ");
		for (String loop : mySet){
			System.out.print(loop + " ");
			}
		
	}
}
