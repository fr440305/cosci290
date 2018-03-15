// Weishu Tan

import java.util.ArrayList;

public class TestObj {
  public static void main (String[] args) {
    ArrayList<Obj> list = new ArrayList<>();
    
    ZombieSoldier z = new ZombieSoldier ();
    list.add(z);
    System.out.println(z);
    
    ZombieBoss zb = new ZombieBoss ();
    list.add(zb);
    System.out.println(zb);
    
    System.out.println(list);
    
  }
}