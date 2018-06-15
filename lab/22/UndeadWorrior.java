// weishu tan
// 2018-05-22

public class UndeadWorrior extends Undead {
  private String leftHandWeapon;
  private String rightHandWeapon;
  
  public UndeadWorrior() {
    super();
  }
  
  public UndeadWorrior(int health, int experience, String name) {
    super(health, experience, name);
  }
  
  public String getLeftHandWeapon() {
    return this.leftHandWeapon;
  }
  
  public String getRightHandWeapon() {
    return this.rightHandWeapon;
  }
  
  public void setLeftHandWeapon(String l) {
    this.leftHandWeapon = l;
  }
  
  public void setRightHandWeapon(String r) {
    this.rightHandWeapon = r;
  }
  
  public String toString() {
    return "UndeadWorrior{"+
      "health: "+this.getHealth()+
      ", experience: "+this.getExperience()+
      ", name: "+this.getName()+
      ", leftHandWeapon: "+this.getLeftHandWeapon()+
      ", rightHandWeapon: "+this.getRightHandWeapon()+
      "}";
  }
  
  /* @override */
  public void attack() {
    System.out.println("UndeadWorrior: Ahhh!");
  }
}