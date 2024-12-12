public class Warrior extends Adventurer {
  private int defense;
  private int criticalHits;
  
  // public static void main(String[] args) {
    
  // }
    
  public Warrior(String name, int HP, int maxHP, int defense, int criticalHits) {
    super(name, HP, maxHP);
    this.defense = defense;
    this.criticalHits = criticalHits;
  }  
}
