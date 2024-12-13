public class Warrior extends Adventurer {
  private int defense;
  private int criticalHits;
    
  public Warrior(String name, int HP, int defense, int criticalHits) {
    super(name, HP, maxHP);
    defense = 10;
    criticalHits = defense/5;
    whirlWindMax = 10;
    whirlWind = whirlWindMax/2;
  }  

  public Warrior(String name, int HP, int defense, int criticalHits) {
    this("Zoey", 25, 10, 10);
  }
  
    public String getSpecialName(){
    return "whirlWind";
  }

  public int getSpecial(){
    return whirlWind;
  }
  
  public void setSpecial(int n){
    whirlWind = n;
  }

  public int getSpecialMax(){
    return whirlWindMax;
  }

  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 10);
    other.applyDamage(damage);
    return this;
  }

    public String specialAttack(Adventurer other){
    if (getSpecial() < 6) {
      other.applyDamage(damage);
    }
    else {
      return "cannot because limit";
    }
  }

  public String support(){
    int hp = 2;
    setHP(getHP() + hp);
    return this;
  }
}
