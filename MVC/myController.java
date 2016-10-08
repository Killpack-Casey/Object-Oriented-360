package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Handles the actions of GUI pieces from the view and the data from the model
 */
public class myController {

	//declare variables to hold the myView and myModel classes
	private myView view;
	private myModel model;
	
	//default constructor passes in the view and model classes 
	public myController(myView view, myModel model){
		
		//adds the two classes to the variables declared above
		this.view = view;
		this.model = model;
		
		//button listener from the view class runs the performListener class
		this.view.buttonListener(new performListener());
	}
	
	public class performListener implements ActionListener{

		//declare variables to be used
		double loanAmount;
		double apr;
		double years;
		double total;
		
		//actionPerformed override method 
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//try block adds user input from the view methods that grab the text it then stores them in variables
			try{
				loanAmount = view.getLoanAmount();
				apr = view.getAnnualRate();
				years = view.getYears();
				
				//calls the result method in the model class which calculates the total loan amount
				model.result(loanAmount, apr, years);
				
				//set the total to what the get total returns from the model class
				view.setTotal(model.getTotal());
			}
			//If there is wrong input from the user or no input in the required text boxes print out an error
			catch(Exception ex){
				String err = "Error, must type numbers and fill in all appropriate text boxes";
				view.error(err);
			}
			
		}
	}
	
}
