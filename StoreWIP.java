package application.model;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class StoreWIP {
	private String wipName;
	private ArrayList<GameInfo> wip = new ArrayList<GameInfo>();

	public StoreWIP(){
		//this.wipName = wipName;
	}

//Getters/Setters---------------------------------------------------------------------------	
	public String getWipName() {
		return wipName;
	}


	public void setWipName(String wipName) {
		this.wipName = wipName;
	}


	public ArrayList<GameInfo> getWip() {
		return wip;
	}


	public void setWip(ArrayList<GameInfo> wip) {
		this.wip = wip;
	}
	
//------------------------------------------------------------------------------------------------------------	
	
//Check is csv files exist/creates files
	public void fileCheck(){
		//Add a method that checks if the csv files exist and loads them in if they do/
		//if they don't creates csv files to store info;
		//Add to StoreComplete && StoreWantToTry
	}
	
//Adds game to arraylist and wipFile
	public void addGame(GameInfo g){
		try{
			FileWriter writer = new FileWriter("wipData.csv");
			writer.write(g.getgName() +"," + g.getgConsole());
			writer.close();
			wip.add(g);
			System.out.println("Game succesfully added to the list");
		} catch(IOException e){
			System.out.println("An error occured writing to the WIP file");
			e.printStackTrace();
		}
		
	}

//Removes game from arraylist and wipFile
	public void removeGame(GameInfo g){
		try{
			File file = new File("wipData.csv");
			File temp = File.createTempFile("temp", ".csv", file.getParentFile());
			String charset = "US-ASCII";
			String delete = g.getgName()+","+g.getgConsole();
			int linecheck = 0;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
			
			for(String line; (line = reader.readLine()) !=null;){
				if(line.equals(delete)){
					line = line.replace(delete, "");
					writer.println(line);
					linecheck++;
				}
				
			}
			
			reader.close();
			writer.close();
			file.delete();
			temp.renameTo(file);
			
			if(linecheck==0)
				System.out.println("Missing game entry");
			else if(linecheck<1)
				System.out.println("Duplicate game entries");
			else{	
				wip.remove(g);
				System.out.println("Game succesfully removed from the list");
			}
			} catch(IOException e){
				System.out.println("An error occured while editing the WIP file ");
				e.printStackTrace();
			}
		
	}
	
//Moves game to complete arraylist	
	public void switchToComplete(GameInfo g, StoreComplete c){
		c.addGame(g);
		removeGame(g);
	}

//Moves game to wanttotry arraylist	
	public void switchToWantToTry(GameInfo g, StoreWantToTry w){
		w.addGame(g);
		removeGame(g);
	}
}
