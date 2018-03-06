public class Zombie {
  private String name;
  private int hp;
  
  // anoymous zomb
  public Zombie () {
    this.name = null;
    this.hp = 100;
  }
  
  public Zombie (String name) {
    this.name = name;
    this.hp = 100;
  }
  
  public String getName () {
    return (this.name == null)?"":this.name;
  }
  public void reduceHp (int d) {
    this.hp -= d;
  }
  public String toString() {
    return (
      ((this.name == null)?
            ("I am anoymous. "):
            ("My name is: " + this.name)) +
      " My hp is: " + this.hp
    );
  }
}
