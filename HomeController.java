package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HomeController{
	@FXML
	private Button enterButton;
	
	public void handle(ActionEvent event) {
		try {
			
			if(((Button) event.getSource()).getText().equals(enterButton.getText())) { 

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/application/view/SelectionMenu.fxml"));
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
