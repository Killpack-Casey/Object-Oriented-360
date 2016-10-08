package Application_Controller_Pattern;
//class that implements the handle request interface that executes the class when selected from the hash map
public class moneyBank implements HandleRequest {
	
	public void execute(int bankNumber) {
		System.out.println();
		System.out.println("CD Rates for, Money Bank: ");
		System.out.println("5yr  ----> 1%");
		System.out.println("10yr ----> 2%");
		System.out.println("15yr ----> 3%");
		System.out.println("20yr ----> 4%");
}

}
