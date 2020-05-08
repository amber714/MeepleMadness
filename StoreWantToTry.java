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

public class StoreWantToTry {
	private String wantName;
	private ArrayList<GameInfo> want = new ArrayList<GameInfo>();
	
	public StoreWantToTry(){
		//this.wantName = wantName;
	}
	
//Getters/Setters----------------------------------------------------	
	public String getWantName() {
		return wantName;
	}

	public void setWantName(String wantName) {
		this.wantName = wantName;
	}

	public ArrayList<GameInfo> getWant() {
		return want;
	}

	public void setWant(ArrayList<GameInfo> want) {
		this.want = want;
	}

//Adds game to arraylist	
	public void addGame(GameInfo g){
		try{
			FileWriter writer = new FileWriter("wantToTryData.csv");
			writer.write(g.getgName() +"," + g.getgConsole());
			writer.close();
			want.add(g);
			System.out.println("Game succesfully added to the list");
		} catch(IOException e){
			System.out.println("An error occured writing to file");
			e.printStackTrace();
		}
		
	}
	
//Removes game from arraylist	
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
				want.remove(g);
				System.out.println("Game succesfully removed from the list");
				}
		} catch(IOException e){
				System.out.println("An error occured while editing the WantToTry file ");
				e.printStackTrace();
			}
		
	}
	
//Moves game to complete arraylist	
	public void switchToComplete(GameInfo g, StoreComplete c){
		c.addGame(g);
		removeGame(g);
	}
	
//Moves game to wip arraylist	
	public void switchWIP(GameInfo g, StoreWIP p){
		p.addGame(g);
		removeGame(g);
	}

}
