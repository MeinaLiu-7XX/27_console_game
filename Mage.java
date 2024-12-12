public class Mage extends Adventurer{
	private int mana, maxMana;

	public Mage(String name){
		super(name);
	}
	public Mage(String name, int hp){
		super(name, hp);
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
		other.applyDamage(2);
	}
}
