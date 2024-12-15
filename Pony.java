public class Pony extends Adventurer {
  private int maxCharges; 
  private int charges; 

  public Pony(String name, int HP) {
    super(name, HP);
    this.maxCharges = 5;
    this.charges = maxCharges;
  }  
  
  public String getSpecialName(){
    return "charges";
  }

  public int getSpecial(){
    return charges;
  }
  
  public void setSpecial(int c){
    charges = c;
  }

  public int getSpecialMax(){
    return maxCharges;
  }

  public String attack(Adventurer other){
    int damage = 5;
    other.applyDamage(damage);
    return other.getName() + " got hit by " + this.getName() + " and took 5 damage.";
  }

  public String support(Adventurer other){
    if (other.getHP() == 0) {
      other.setHP(other.getmaxHP());
      return this.getName() + " revived " + other.getName() + ".";
    } else {
      return "Cannot revive, because" + other.getName() + " is alive.";
    }
  }

  public String support(){
    int heal = 5;
    
    this.setHP(this.getHP() + heal);

    if (this.getHP() > this.getmaxHP()) {
      this.setHP(this.getmaxHP());
    }
    return this.getName() + " healed itself to " + this.getHP() + ".";
  }

  public String specialAttack(Adventurer other){
    int damage = 20;
    if (charges > 0) {
      other.applyDamage(damage);
      charges -= 1;
      return other.getName() + "took " + damage + ".";
    }
    else {
      return this.getName() + " is out of charges.";
    }
  }
}
