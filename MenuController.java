package application.controller;

import application.Main;
import  application.model.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


/**
 * 
 * @author amberrodriguez
 * handles the table of games
 */

public class MenuController{
	
/*	@FXML 
	private Label completed;
	
	@FXML
	private Label inProgress;
	*/
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button addButton;
	
	@FXML
	private ListView<String> completedList;
	
	@FXML
	private ListView<String> inProgressList;

	
	public void handle(ActionEvent event) {
		
		try {
			
			if(((Button) event.getSource()).getText().equals(backButton.getText())) { 

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/view/Home.fxml"));
				Parent root = loader.load();
				Main.s.setScene(new Scene(root, 800, 800));
				Main.s.show();
			
		}
			else if((((Button) event.getSource()).getText().equals(addButton.getText()))) { 

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/view/AddGame.fxml"));
				Parent root = loader.load();
				Main.s.setScene(new Scene(root, 800, 800));
				Main.s.show();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	
	
}
}
