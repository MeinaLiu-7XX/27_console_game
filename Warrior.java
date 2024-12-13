public class Warrior extends Adventurer {
  private int defense;
  private int criticalHits;
    
  public Warrior(String name, int HP, int maxHP, int defense, int criticalHits) {
    super(name, HP, maxHP);
    this.defense = defense;
    this.criticalHits = criticalHits;
  }  

  public Warrior(String name, int hp){
    this("Zoey", 50);  
  }
  
}
