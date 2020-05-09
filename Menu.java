package application.model;

import javafx.beans.property.*;

public class Menu {

	private SimpleStringProperty completed, inProgress;
	
	
	public Menu(String completed, String inProgress) {
		this.completed = new  SimpleStringProperty(completed);
		this.inProgress = new SimpleStringProperty(inProgress);
	
	}


	public SimpleStringProperty getCompleted() {
		return completed;
	}


	public void setCompleted(SimpleStringProperty completed) {
		this.completed = completed;
	}


	public SimpleStringProperty getInProgress() {
		return inProgress;
	}


	public void setInProgress(SimpleStringProperty inProgress) {
		this.inProgress = inProgress;
	}
	
	
	
}
