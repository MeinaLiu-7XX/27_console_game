public class Pony extends Adventurer {
  private int defense;
  private int criticalHits;
    
  public Pony(String name, int HP, int defense, int criticalHits) {
    super(name, HP, maxHP);
    defense = 50;
    criticalHits = defense/5;
    magicWandMax = 20;
    magicWand = magicWandMax/2;
  }  

  public Pony(String name, int HP, int defense, int criticalHits) {
    this("Pony", 20, 50, 10);
  }
  
  public String getSpecialName(){
    return "magicWand";
  }

  public int getSpecial(){
    return magicWand;
  }
  
  public void setSpecial(int n){
    magicWand = n;
  }

  public int getSpecialMax(){
    return magicWandMax;
  }

  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 10);
    other.applyDamage(damage);
    return this;
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() < 4) {
      other.applyDamage(damage);
    }
    else {
      return "cannot because limit";
    }
  }

  public String support(){
    int hp = 5;
    setHP(getHP() + hp);
    return this;
  }
  
}
