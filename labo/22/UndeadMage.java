// weishu tan
// 2018-05-22

public class UndeadMage extends Undead {
  private String spellOne;
  private String spellTwo;
  
  public UndeadMage() {
    super();
  }
  
  public UndeadMage(int health, int experience, String name) {
    super(health, experience, name);
  }
  
  public int getHealth() {
    return super.getHealth();
  }
  
  public int getExperience() {
    return super.getExperience();
  }
  
  public String getName() {
    return super.getName();
  }
  
  public void setHealth(int health) {
    super.setHealth(health);
  }
  
  public void setExperience(int ex) {
    super.setExperience(ex);
  }
  
  public void setName(String name) {
    super.setName(name);
  }
  
  /* @override */
  public String toString() {
    return "UndeadMage{health: "+this.getHealth()+
      ", experience: "+this.getExperience()+
      ", name: "+this.getName()+"}";
  }
  
  /* @override */
  public void attack() {
    System.out.println("UndeadMage: Ahhh!");
  }
}