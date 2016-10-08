package MVC;
/* 
 * This is where data is stored and calculated, that is used for the GUI
 */
public class myModel {

//declare variables
private double loanAmount;
private double apr;
private double years;
private double total;

//Method calculates the total loan amount
public void result(double loanAmount, double apr, double years){
	total = ((loanAmount * apr) + loanAmount) * years;
}

//method returns the total
public double getTotal(){
	return total;
	
}



	}


