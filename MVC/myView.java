package MVC;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * This is where the GUI is made
 */
public class myView extends JFrame {
	
	//create labels, text fields of input and output and a button
	private JLabel loanAmount = new JLabel("Loan Amount");
	private JTextField tfLoanAmount = new JTextField(20); 
	private JLabel annualRate = new JLabel("Annual Percentage Rate");
	private JTextField tfAnnualRate = new JTextField(20);
	private JLabel years = new JLabel("Loan length (in years)");
	private JTextField tfYears = new JTextField(20);
	private JLabel totalAmount = new JLabel("Total");
	private JTextField tfTotalAmount = new JTextField(30);
	private JButton calculate = new JButton("Calculate");

	//default constructor
	public myView(){
		
		//create a panel
		JPanel myPanel = new JPanel();
		
		//add labels, text fields, and the button to the panel
		myPanel.add(loanAmount);
		myPanel.add(tfLoanAmount);
		myPanel.add(annualRate);
		myPanel.add(tfAnnualRate);
		myPanel.add(years);
		myPanel.add(tfYears);
		myPanel.add(totalAmount);
		myPanel.add(tfTotalAmount);
		myPanel.add(calculate);
		
		//add the panel to the frame
		this.add(myPanel);
	}
	
	//method returns the user input from the loan amount text box
	public double getLoanAmount(){
		return Double.parseDouble(tfLoanAmount.getText());
		
	}
	
	//method returns the user input from the annual rate text box
	public double getAnnualRate(){
		return Double.parseDouble(tfAnnualRate.getText());
		
	}
	
	//method returns the user input from the years text box
	public double getYears(){
		return Double.parseDouble(tfYears.getText());
		
	}
	
	//method returns the data from the total amount text box
	public double getTotal(){
		return Double.parseDouble(tfTotalAmount.getText());
		
	}
	
	//method sets the data for the total amount text box
	public void setTotal(Double tTotalAmount){

		        tfTotalAmount.setText(Double.toString(tTotalAmount));
		         
		
		    }
	
	//create an action listener for my button
	void buttonListener(ActionListener calcListener){
		calculate.addActionListener(calcListener);
	}
	
	//Method to handle errors in program
	void error(String message){
		JOptionPane.showMessageDialog(this, message);
	}


	
}
