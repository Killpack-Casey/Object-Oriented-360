package Application_Controller_Pattern;
import java.util.Scanner;
/*
 * The application is where the user interfaces with the program. Processing of the user's input is sent
 * to the application controller to process the request.
 */

public class Application {

	public static void main(String[] args) {
		//Create scanner to use for user input
		Scanner scanner = new Scanner(System.in);
		
		//Create an instance of the AppController class to call in the main method
		AppController myController = new AppController();
		
		//Information for the user
		System.out.println("Welcome to Invest In Your Future");
		
		//Information for the user
		System.out.println("Please type the number that coressponds to the bank you'd like to invest in with a CD account: ");
		System.out.println("1 = Your Bank " + "2 = Best Bank " + "3 = Money Bank");
		
		//Store user input
		int bankNumber = scanner.nextInt();
		
		//call method within the controller to process user's request
		myController.processRequest(bankNumber);

	}

}
