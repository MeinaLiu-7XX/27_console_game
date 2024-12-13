public class Archer extends Adventurer{
	private int stamina, maxStamina;

	public Archer(String name){
		super(name, 15);
		stamina = 15;
                maxStamina = 15;
	}
	public Archer(String name, int stamina){
		super(name, 15);
		this.stamina = stamina;
		this.maxStamina = stamina;
	}
	public Archer(String name, int hp, int stamina){
		super(name, hp);
		this.stamina = stamina;
		this.maxStamina = stamina;
	}

	public String getSpecialName(){
		return "Stamina";
	}
	public int getSpecial(){
		return stamina;
	}
	public void setSpecial(int n){
		if(stamina + n > maxStamina){
			stamina = maxStamina;
		}
		else{
			stamina = n;
		}
	}
	public int getSpecialMax(){
		return maxStamina;
	}

	public String attack(Adventurer other){
		other.applyDamage(1);
		restoreSpecial(2);
		return getName() + " shot an arrow and hit " + other.getName() + " for 3 damage! They then pause, catching their breath.";
	}
	public String support(Adventurer other){
		other.setSpecial(other.getSpecialMax());
		return getName() + " restores " + other.getName() + "'s " + other.getSpecialName() + " to full!";
	}
	public String support(){
		setSpecial(getSpecialMax());
		return getName() + " restores their own stamina to full!";
	}
	public String specialAttack(Adventurer other){
		other.applyDamage(12);
		setSpecial(getSpecial() - 8);
		return getName() + " fired a volley of arrows and hit " + other.getName() + " for 12 damage!";
	}
}
