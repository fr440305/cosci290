public class Zombie {
  public String name;
  public int hp;
  
  // anoymous zomb
  public Zombie () {
    this.name = null;
    this.hp = 100;
  }
  
  public Zombie (String name) {
    this.name = name;
    this.hp = 100;
  }
  
  public String toString() {
    return (
      ((this.name == null)?
            ("I am anoymous. "):
            ("My name is: " + this.name)) +
      "My hp is: " + this.hp
    );
  }
}