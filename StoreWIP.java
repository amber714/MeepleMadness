//Author Otimeyin Efejuku cdy129

package application.model;
import java.util.ArrayList;
import java.io.*;

public class StoreWIP {
	private String wipName;
	private ArrayList<GameInfo> wip = new ArrayList<GameInfo>();

	public StoreWIP(){
		fileCheck();
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
		try{
			File file = new File("wipData.csv");
			if(file.createNewFile())
				System.out.println("wipData.csv file created");
			else
				System.out.println("wipData.csv file already exists");
		} catch(IOException e){
			System.out.println("An error occured searching for wipData.csv file");
			e.printStackTrace();
		}
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
