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
//Edits to add in save data
import application.model.*;

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
	
	private StoreWIP wip = new StoreWIP();
	
	private StoreComplete complete = new StoreComplete();
	
	public void handle(ActionEvent event) {
		try {
	
		
			if(((Button) event.getSource()).getText().equals(save.getText())) { 
				
				
				//save data - call method that will add info
				if(completed!=null){
					if(complete.alreadyExists(new GameInfo(gameTitle.getText(), console.getText()), "completeData.csv")!=true)
						complete.addGame(new GameInfo(gameTitle.getText(), console.getText()));
				}
				else if(inProgress!=null){
					if(wip.alreadyExists(new GameInfo(gameTitle.getText(), console.getText()), "wipData.csv")!=true)
						wip.addGame(new GameInfo(gameTitle.getText(), console.getText()));
				}	
				//-------------------------------------------------------
				

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
