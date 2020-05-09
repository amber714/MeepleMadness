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
import application.model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javafx.scene.layout.StackPane;

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
	public void display(){
		try {
			completedList = new ListView<String>();
			inProgressList = new ListView<String>();
			
			
			File cfile = new File("completeData.csv");
			File pfile = new File("wipData.csv");
			String charset = "US-ASCII";
			BufferedReader cReader = new BufferedReader(new InputStreamReader(new FileInputStream(cfile), charset));
			for(String line; (line = cReader.readLine()) !=null;){
				line = line.replace(",", " ");
				completedList.getItems().add(line);
			}
			
			BufferedReader pReader = new BufferedReader(new InputStreamReader(new FileInputStream(pfile), charset));
			for(String line; (line = pReader.readLine()) !=null;){
				line = line.replace(",", " - ");
				inProgressList.getItems().add(line);
			}
			pReader.close();
			cReader.close();
			
			StackPane stackPane = new StackPane(completedList);
			StackPane stackPaneProgress = new StackPane(inProgressList);
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
