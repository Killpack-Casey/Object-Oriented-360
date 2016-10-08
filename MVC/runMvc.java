package MVC;
import java.awt.Frame;

import javax.swing.JFrame;
/*
 * runs the MVC application
 */
public class runMvc {

	public static void main(String[] args) {
		
		//create an instance of the model class
		myModel model = new myModel();
		
		//create an instance of the view class and pass in the model class
		myView view = new myView();
		
		//create an instance of the controller class and pass in the model and view classes
		myController control = new myController(view, model);
		
		//Set the frame to be visible, set the size, and allow the frame to close when directed by the user
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
		

	}

}
