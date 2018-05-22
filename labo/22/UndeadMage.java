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
  
  public String getSpellOne() {
    return this.spellOne;
  }
  
  public String getSpellTwo() {
    return this.spellTwo;
  }
  
  public void setSpellOne(String sp1) {
    this.spellOne = sp1;
  }
  
  public void setSpellTwo(String sp2) {
    this.spellTwo = sp2;
  }
  
  /* @override */
  public String toString() {
    return "UndeadMage{"+
      "health: "+this.getHealth()+
      ", experience: "+this.getExperience()+
      ", name: "+this.getName()+
      ", spellOne: "+this.getSpellOne()+
      ", spellTwo: "+this.getSpellTwo()+
      "}";
  }
  
  /* @override */
  public void attack() {
    System.out.println("UndeadMage: Ahhh!");
  }
}