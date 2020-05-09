//Author Otimeyin Efejuku cdy129

package application.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoreComplete {
	private String completeName;
	private ArrayList<GameInfo> complete = new ArrayList<GameInfo>();
	
	public StoreComplete(){
		fileCheck();
	}
	
//Getters/Setters-----------------------------------------------------------------	
public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public ArrayList<GameInfo> getComplete() {
		return complete;
	}

	public void setComplete(ArrayList<GameInfo> complete) {
		this.complete = complete;
	}
	//----------------------------------------------------------------------------
	
	//Check is csv files exist/creates files
	public void fileCheck(){		
		try{
			File file = new File("completeData.csv");
			if(file.createNewFile())
				System.out.println("completeData.csv file created");
			else
				System.out.println("completeData.csv file already exists");
		} catch(IOException e){
			System.out.println("An error occured searching for completeData.csv file");
			e.printStackTrace();
		}
	}
	

//Adds game to arraylist	
	public void addGame(GameInfo g){
		try{
			FileWriter writer = new FileWriter("completeData.csv");
			writer.write(g.getgName() +"," + g.getgConsole());
			writer.close();
			complete.add(g);
			System.out.println("Game succesfully added to the list");
		} catch(IOException e){
			System.out.println("An error occured writing to file");
			e.printStackTrace();
		}

	}
	
//Removes game from arraylist 
	public void removeGame(GameInfo g){
		try{
			File file = new File("completeData.csv");
			File temp = File.createTempFile("temp", ".csv", file.getParentFile());
			String charset = "US-ASCII";
			String delete = g.getgName()+","+g.getgConsole();
			int linecheck = 0;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
			
			for(String line; (line = reader.readLine()) !=null;){
				if(line.equals(delete)){
					line = line.replace(delete, "");
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
				complete.remove(g);
				System.out.println("Game succesfully removed from the list");
			}
			} catch(IOException e){
				System.out.println("An error occured while editing the Complete file ");
				e.printStackTrace();
			}
	}
	
//Moves game to wip array;ist	
	public void switchToWIP(GameInfo g, StoreWIP p){
		p.addGame(g);
		removeGame(g);
	}
	
	public boolean alreadyExists(GameInfo g, String fileName){
		boolean exist = false;
		try{
			int count = 0;
			String charset = "US-ASCII";
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			for(String line; (line = reader.readLine()) !=null;){
				if(line.equals(g.getgName()+","+g.getgConsole())){
					count++;
				}
			}
			
			if(count>0)
				exist = true;
			reader.close();
			return exist;
		} catch(IOException e){
			e.printStackTrace();
		}
		return exist;
	}
	
}
