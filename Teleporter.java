public class Teleporter extends Adventurer {
  private int mana;
  private int maxMana;
    
  public Teleporter (String name, int HP) {
    super(name, HP);
    maxMana = 100;
    mana = 50;
  }  
  
    public String getSpecialName(){
    return "mana";
  }

  public int getSpecial(){
    return mana;
  }
  
  public void setSpecial(int m){
    mana = m;
  }

  public int getSpecialMax(){
    return maxMana;
  }

  public String attack(Adventurer other) {
    int damage = (int)(Math.random() * 10);
    other.applyDamage(damage);
    return this.getName() + "summons a hammer." + other.getName() + "was attacked by " + this.getName() + "and took in " + damage + " damage.";
  }

  public String specialAttack(Adventurer other){
    int damage = 10;
    if (mana >= 50) {
      other.applyDamage(damage);
      mana -= 50;
      return this.getName() + "teleports behind " + other.getName() + ". " + other.getName() + "was attacked by " + this.getName() + "and took in " + damage + " damage.";
    } else {
      return "cannot because limit";
    }
  }

  public String support(){
    return support(this);
  }
  
  public String support(Adventurer other) {
    int increaseHP = 2;
    other.setmaxHP(other.getmaxHP() + increaseHP);
    return this.getName() + " increased " + other.getName() +"'s max HP to " + other.getHP() + ".";
  }
}