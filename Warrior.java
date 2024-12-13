public class Warrior extends Adventurer {
  private int defense;
  private int criticalHits;
    
  public Warrior(String name, int HP, int defense, int criticalHits) {
    super(name, HP, maxHP);
    defense = 10;
    criticalHits = defense/5;
  }  

  public Warrior(String name, int HP, int defense, int criticalHits) {
    this("Zoey", 25, 10, 10);
  }
}
