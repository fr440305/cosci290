// weishu tan
// 2018-05-22

import java.util.ArrayList;

public class Main {
  
  public static ArrayList<Undead> generateUndeads(int n) {
    ArrayList<Undead> undeads = new ArrayList<Undead>();
    for (int i = 0; i < n; i++) {
      undeads.add(
        ((int)(Math.random()*2) == 0) ?
          new UndeadWorrior() :
          new UndeadMage()
      );
    }
    return undeads;
  }
  
  public static void main(String[] args) {
    for (Undead u : generateUndeads(5)) {
      u.attack();
    }
  }
}