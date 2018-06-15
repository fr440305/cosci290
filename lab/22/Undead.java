// weishu tan
// 2018-05-22

public abstract class Undead {
  private int health;
  private int experience;
  private String name;
  
  public Undead() {
    this.health = 100;
    this.experience = 0;
    this.name = "Anoymous";
  }
  
  public Undead(int health, int experience, String name) {
    this.health = health;
    this.experience = experience;
    this.name = name;
  }
  
  public int getHealth() {
    return this.health;
  }
  
  public int getExperience() {
    return this.experience;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setHealth(int health) {
    this.health = health;
  }
  
  public void setExperience(int ex) {
    this.experience = ex;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String toString() {
    return "Undead{health: "+this.health+
      ", experience: "+this.experience+
      ", name: "+this.name+"}";
  }
  
  public abstract void attack();
}