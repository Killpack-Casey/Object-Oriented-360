package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class listInterface {
			
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberAmount;
		
		//Declare a LinkedList of Integer types
		List<Integer> myLinkedList = new LinkedList<Integer>(); 
		
		//Declare an ArrayList of Integer types
		List<Integer> myArrayList = new ArrayList<Integer>();
		
		System.out.println("Please enter the amount of numbers you want to store: ");
		System.out.println("NOTE: NEEDS TO BE AT LEAST MORE THAN 500,000 NUMBERS but less than 600,000 THAT YOU WANT TO STORE.");
		
		//retrieve input from user and store in numberAmount variables
		numberAmount = scanner.nextInt();
		
		//fill array list and linked list from the size specified from the user
		for(int i = 0; i < numberAmount; i++){
			myArrayList.add(i);
			myLinkedList.add(i);
		}
		
		//check to make sure the array and linked list were created successfully
		if (myArrayList.size() == numberAmount && myLinkedList.size() == numberAmount){
		System.out.println("Array List and Linked List CREATED with " + numberAmount + " elements.");
		}
		else
			System.out.println("THERE WAS AN ERROR, ABORT!!!! ABORT!!!!");
		
		//some formatting to make things look nicer
		for(int i = 0; i < 100; i++){
			System.out.print(".");
		}
		System.out.println();
		System.out.println("Removing the first 1,000 elements from an array list");
		
		//Bad code takes longer to remove from the beginning of an array list than a linked list.
		long aStart = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++){
			myArrayList.remove(i);
		}
		long aEnd = System.currentTimeMillis();
		
		//Print out the amount of time it takes to remove the first 50 elements
		System.out.println("Amount of time to remove the first 50 elements of an array list: " + (aEnd - aStart) + " milliseconds");
		
		//Better code, a lot quicker in removing elements from the beginning of a list.
		long lstart = System.currentTimeMillis();
		for(int i = 0; i < 50; i++){
			myLinkedList.remove(i);
		}
		long lend = System.currentTimeMillis();
		
		//Print out the amount of time it takes to remove the first 50 elements
		System.out.println("Amount of time to remove the first 50 elements of a Linked list: " + (lend - lstart) + " milliseconds");

		//-------------adding to the ArrayList------------------//
		System.out.println();
		System.out.println("Adding to the ArrayList");
		
		//Happy Path
		myArrayList.add(400000, 5);
		if (myArrayList.get(400000) == 5){
			System.out.println("Addition of number " + myArrayList.get(400000) + " to index 400,000 completed successfully");
		}
		
		//Nasty Path: User has to create the array size which is suppose to be less than 600000 elements. You can't add more than the size
		//of the array
		try{
			myArrayList.add(600000, 5);
		
		}
		catch(Exception e){
			System.out.println("YOU CANNOT ADD TO AN ARRAY LIST AT AN INDEX GREATER THAN THE LENGTH OF THE ARRAY");
		}
		
		// --------------------sorting the ArrayList and adding invalid types to ArrayList----------------//
		System.out.println();
		System.out.println("Sorting an ArrayList");
		
		//populate array
		//Nasty Path
		//myArrayList.add(0, "A");
		
		//Nasty Path
		//myArrayList.sort();
		
		//Happy Path
		Collections.sort(myArrayList);
		System.out.println("Sorted");
	}

}


