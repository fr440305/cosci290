// Author: Weishu Tan (cosci 290 group 4)
// Manager: Christian Castillo

public class Spider {
  
  private int health;
  private int attack;
  private int defense;
  
  public Spider () {
    this.health = 15;
    this.attack = 5;
    this.defense = 5;
  }
  
  public int getHealth () {
    return this.health;
  }
  
  public int getAttack () {
    return this.attack;
  }
  
  public int getDefense () {
    return this.defense;
  }
  
  public void setHealth (int h) {
    this.health = h;
  }
  
  public void setAttack (int a) {
    this.attack = a;
  }
  
  public void setDefense (int d) {
    this.defense = d;
  }
  
  public String toString() {
    return
      "I am a spider. My informations:\n" +
      "\t health " + this.health +
      "\t attack " + this.attack + 
      "\t defense " + this.defense;
  }
  
  
}
