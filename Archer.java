public class Archer{
	private int mana, maxMana;

	public Mage(String name){
		super(name);
		mana = 20;
                maxMana = 20;
	}
	public Mage(String name, int mana){
		super(name);
		this.mana = mana;
		this.maxMana = mana;
	}
	public Mage(String name, int hp, int mana){
		super(name, hp);
		this.mana = mana;
		this.maxMana = mana;
	}

	public String getSpecialName(){
		return "mana";
	}
	public int getSpecial(){
		return mana;
	}
	public void setSpecial(int n){
		if(mana + n > maxMana){
			mana = maxMana;
		}
		else{
			mana = n;
		}
	}
	public int getSpecialMax(){
		return maxMana;
	}

	public String attack(Adventurer other){
		other.applyDamage(1);
		restoreSpecial(2);
		return getName() + " hit " + other.getName() + " for 1 damage! They then pause, restoring mana with the shed blood.";
	}
	public String support(Adventurer other){
		if(other.getHP() + 10 > other.getmaxHP()){
			other.setHP(other.getmaxHP());
		}
		else{
			other.setHP(other.getHP() + 10);
		}
		return getName() + " heals " + other.getName() + " for 10 HP!";
	}
	public String support(){
		if(getHP() + 10 > getmaxHP()){
                        setHP(getmaxHP());
                }
                else{
                        setHP(getHP() + 10);
                }
		return getName() + " heals themselves for 10 HP!";
	}
	public String specialAttack(Adventurer other){
		other.applyDamage(10);
		setSpecial(getSpecial() - 5);
		return getName() + " used fireball and hit " + other.getName() + " for 10 damage!";
	}
}
