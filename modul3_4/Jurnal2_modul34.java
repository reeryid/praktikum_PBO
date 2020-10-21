package modul3_4;

interface Player {
		public void play();
		public String getRole();
		public void setRole(String role);
	}


class Suspect {
	String sabotage;
	int kill;
	void suspect(String sabotage) {
		this.sabotage=sabotage;
	}
	void suspect(int kill) {
		this.kill=kill;
	}
	void task() {
		System.out.println("\nTasks (Crewmate)");
		System.out.println("1. Clean O2 Filter");
		System.out.println("2. Empty Garbage");
		System.out.println("3. Clear Asteroids");
		System.out.println("4. Fix Wiring");
		System.out.println("5. Divert Power");
	}
	
}

class Red extends Suspect implements Player{
	String role;
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void play() {
		System.out.println("Red join the Lobby");
	}
	
	void task() {
		if(this.role.equalsIgnoreCase("impostor")) {
			System.out.println("\nSabotage and Kill everyone. (Impostor)");
			System.out.println("Fake Tasks");
			System.out.println("1. Clean O2 Filter");
			System.out.println("2. Empty Garbage");
			System.out.println("3. Clear Asteroids");
			System.out.println("4. Fix Wiring");
			System.out.println("5. Divert Power");			
		}
		else {
			super.task();
		}
	}
}

class Green extends Suspect implements Player{
	String role;
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void play() {
		System.out.println("Green join the Lobby");
	}
	void task() {
		if(this.role.equalsIgnoreCase("impostor")) {
			System.out.println("\nSabotage and Kill everyone. (Impostor)");
			System.out.println("Fake Tasks");
			System.out.println("1. Clean O2 Filter");
			System.out.println("2. Empty Garbage");
			System.out.println("3. Clear Asteroids");
			System.out.println("4. Fix Wiring");
			System.out.println("5. Divert Power");
			
		}
		else {
			super.task();
		}
	}
}

class Yellow extends Suspect implements Player{
	String role;
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void play() {
		System.out.println("Yellow join the Lobby");
	}
	void task() {
		if(this.role.equalsIgnoreCase("impostor")) {
			System.out.println("\nSabotage and Kill everyone. (Impostor)");
			System.out.println("Fake Tasks");
			System.out.println("1. Clean O2 Filter");
			System.out.println("2. Empty Garbage");
			System.out.println("3. Clear Asteroids");
			System.out.println("4. Fix Wiring");
			System.out.println("5. Divert Power");
		}
		else {
			super.task();
		}
	}
}

class Purple extends Suspect implements Player{
	String role;
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void play() {
		System.out.println("Purple join the Lobby");
	}
	void task() {
		if(this.role.equalsIgnoreCase("impostor")) {
			System.out.println("\nSabotage and Kill everyone. (Impostor)");
			System.out.println("Fake Tasks");
			System.out.println("1. Clean O2 Filter");
			System.out.println("2. Empty Garbage");
			System.out.println("3. Clear Asteroids");
			System.out.println("4. Fix Wiring");
			System.out.println("5. Divert Power");
		}
		else {
			super.task();
		}
	}
}


public class Jurnal2_modul34{
    public static void main(String[] args) {
    	
        Red red=new Red();
        Yellow yellow=new Yellow();
        Purple purple=new Purple();
        Green green=new Green();
        
        red.play();
        yellow.play();
        purple.play();
        green.play();
        
        red.setRole("impostor");
        yellow.setRole("crewmate");
        purple.setRole("crewmate");
        green.setRole("crewmate");
        
        red.task();
        yellow.task();
        purple.task();
        green.task();
       
    }
}