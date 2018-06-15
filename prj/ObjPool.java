// Weishu Tan

public class ObjPool {
  private static int counter = 0;
  //public static ArrayList<Obj> list = new ArrayList<Obj>();
  
  public static int count () {
    counter += 1;
    return counter;
  }
  
  /*
  public static String toString() {
    String ret = "";
    for (Obj o : list) {
      ret += (o.toString() + "\n");
    }
    return ret;
  }
  */
}