public class Warrior extends Adventurer {
  private int defense;
  private int criticalHits;
    
  public Warrior(String name, int HP, int defense, int criticalHits) {
    super(name, HP, maxHP);
    this.defense = defense;
    this.criticalHits = criticalHits;
    this("Zoey", 25, 10, 2);  
  }  
}
