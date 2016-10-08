package Application_Controller_Pattern;
//class that implements the handle request interface that executes the class when selected from the hash map
public class yourBank implements HandleRequest{

	public void execute(int bankNumber) {
		System.out.println();
		System.out.println("CD Rates for, Your Bank: ");
		System.out.println("10yr ----> 1%");
		System.out.println("20yr ----> 1.5%");
		System.out.println("30yr ----> 5%");
		System.out.println("40yr ----> 10%");
		
	}

}
