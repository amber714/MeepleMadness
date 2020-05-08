package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddGameController {
	
	@FXML
	private TextField gameTitle;
	
	@FXML
	private TextField console;
	
	@FXML
	private CheckBox completed;
	
	@FXML
	private CheckBox inProgress;
	
	@FXML
	private Button save;
	
	@FXML
	private Button back;
	
	public void handle(ActionEvent event) {
		try {
	
		
			if(((Button) event.getSource()).getText().equals(save.getText())) { 
				
				
				//save data - call method that will add info
				

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/view/SelectionMenu.fxml"));
				Parent root = loader.load();
				Main.s.setScene(new Scene(root, 800, 800));
				Main.s.show();
			
		}
			else if((((Button) event.getSource()).getText().equals(back.getText()))) { 

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/view/SelectionMenu.fxml"));
				Parent root = loader.load();
				Main.s.setScene(new Scene(root, 800, 800));
				Main.s.show();
			}
		
		}catch(Exception e) {
			
		}
	
	
	
	}

}
