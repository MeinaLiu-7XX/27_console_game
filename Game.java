import java.util.Scanner;

public class Game{
    	public static void main(String[] args){
        	Adventurer Enemy = new Pony("Cyberpony", 50);
		Adventurer Player;
		Scanner input = new Scanner(System.in);
		System.out.println("What is your character's name?");
		String name = input.nextLine();
		input.nextLine();
		System.out.println("What is your character's class? (Archer (a), Mage (m), Pony (p), Teleporter (t))");
		String cClass = input.nextLine();
		input.nextLine();
		System.out.println("How much HP does your character have?");
		int HP = input.nextInt();
		input.nextLine();
		if(cClass.equals("a")){
			Player = new Archer(name, HP);
		}
		else if(cClass.equals("m")){
			Player = new Mage(name, HP);
		}
		else if(cClass.equals("p")){
			Player = new Pony(name, HP);
		}
		else if(cClass.equals("t")){
			Player = new Teleporter(name, HP);
		}
		else{
			System.out.println("Invalid class entered");
		}
    	}
}
