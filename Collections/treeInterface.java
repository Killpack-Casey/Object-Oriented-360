package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.swing.text.TabSet;


public class treeInterface {

	public static void main(String[] args) {
		
		// Tree orders things in natural order, Set does not allow for duplicates
		//Declare a TreeSet
		//TreeSet's are also not indexed unlike a list
		TreeSet<Integer> myTree = new TreeSet<Integer>();
		List<Integer> myArrayList = new ArrayList<Integer>();
		//Collections.reverseOrder(new TreeSet);
		
		//Add integers to treeSet
		myTree.add(3);
		myTree.add(7);
		myTree.add(8);
		myTree.add(7);
		myTree.add(6);
		myTree.add(2);
		myTree.add(2);
		myTree.add(4);
		myTree.add(1);
		myTree.add(5);
		myTree.add(5);
		
		//Add integers to my list
		myArrayList.add(3);
		myArrayList.add(7);
		myArrayList.add(8);
		myArrayList.add(7);
		myArrayList.add(6);
		myArrayList.add(2);
		myArrayList.add(2);
		myArrayList.add(4);
		myArrayList.add(1);
		myArrayList.add(5);
		myArrayList.add(5);
	
		
		//Call procedure to print out TreeSet
		orderNoDuplicates(myTree);
		
		//Call procedure to find the number five in the array list and tree set. Return true if found, false if not found
		findNumber(myTree, myArrayList);
		
		testTree(myTree, myArrayList);
	}

	
	//Method prints out elements in my TreeSet
	public static void orderNoDuplicates(TreeSet<Integer> myTree){
		System.out.print("From my TreeSet:        ");
		for (Integer loop : myTree){
			System.out.print(loop + " ");
			}
		System.out.println();
	}
	
	//Method to find the number 5
	public static void findNumber(TreeSet<Integer> myTree, List<Integer> myArrayList){
		
			//Print out True if the number is found in the set or false if not found
		    //Good code for finding elements quick
			System.out.println(myTree.contains(5));
			
			//Print out True if the number is found in the set or false if not found
			//Bad cod for finding elements much slower than a treeset
			for (int i = 0; i < myArrayList.size(); i++){
				if(myArrayList.get(i) == 5){
					break;
					
		} 
				else
					continue;
					
	}System.out.println("true");
}
	
	public static void testTree(TreeSet<Integer> myTree, List<Integer> myArrayList){
	
		//create a TreeSet to hold the reverse values
		TreeSet<Integer> tReverse = new TreeSet<Integer>();
		
		//nasty path: Cannot reverse the order of a TreeSet doing it this way 
		//Collections.reverseOrder(myTree);
		
		//nasty path: Cannot do the reverse order of a TreeSet using a Comparator
		//Comparator<Integer> compare = Collections.reverseOrder(null);
		//Collections.sort(myTree, compare);
		
		System.out.println();
		System.out.println("Loop thorugh array list in reverse order");
	
		//happy path: Reverse the order of a list using a comparator
		Comparator<Integer> compare2 = Collections.reverseOrder(null);
		Collections.sort(myArrayList, compare2);
		
		for (int i = 0; i < myArrayList.size(); i++){
			System.out.println(myArrayList.get(i));
		}
	
		System.out.println();
		System.out.println("Loop through my Tree Set in reverse order");
		
		//happy path: Reverse the order of myTree and put it in the tReverse treeSet
		tReverse = (TreeSet<Integer>)myTree.descendingSet();
		
		//create an iterator and store treeSet in it
		Iterator<Integer> it;
		it = tReverse.iterator();
		
		//loop through the treeSet
		while (it.hasNext()){
			   System.out.println(it.next() + " ");}
		
		System.out.println();
		
		//nasty path
		try{
			myTree.remove(null);
		}
		catch(Exception e){
			System.out.println("This will create a NULL POINTER EXCEPTION error");
		}
			
	}
}