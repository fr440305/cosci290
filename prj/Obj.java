// Weishu Tan

public class Obj {
  private int id;
  
  public Obj () {
    this.id = ObjPool.count();
    //ObjPool.list.add(this);
  }
  
  public int getId () {
    return this.id;
  }
  
  public String toString () {
    return "id: " + this.id;
  }
  
}
