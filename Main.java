package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	public static Stage s;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			s = primaryStage;
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Home.fxml"));
			//Label homeLabel  = new Label("Game Tracker");
			
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*private Pane loadSelection() throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
		
		Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(
				))
				
		
		
		return null;
		
	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
