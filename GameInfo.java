// Author Otimeyin Efejuku cdy129

package application.model;


public class GameInfo {
	private String gName, gConsole;
	
	public GameInfo(String gName, String gConsole){
		this.gName = gName;
		this.gConsole = gConsole;
	}

//Getters/Setters-------------------------------------------------------------	
	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgConsole() {
		return gConsole;
	}

	public void setgConsole(String gConsole) {
		this.gConsole = gConsole;
	}
	
}
