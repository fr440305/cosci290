
import java.util.ArrayList;

public class Student extends Person {
  private String major;
  private double gpa;
  private ArrayList<String> classes;
  
  public Student() {
    super();
    this.major = "";
    this.gpa = 0;
    this.classes = new ArrayList<String>();
  }
  
  public String getMajor() {
    return this.major;
  }
  
  public boolean setMajor(String m) {
    this.major = m;
    return true; // may changes in future.
  }
  
  public double getGPA () {
    return this.gpa;
  }
  
  public boolean setGPA (int g) {
    if (g >= 0) {
      this.gpa = g;
      return true;
    } else {
      return false;
    }
  }
  
  public boolean addClass (String c) {
    this.classes.add(c);
    return true;
  }
  
  public boolean delClass (String c) {
    int i;
    if ((i = this.findClass(c)) != -1) {
      this.classes.remove(i);
      return true;
    } else {
      return false;
    }
  }
  
  public int findClass (String c) {
    for (int i = 0; i < this.classes.size(); i++) {
      if (this.classes.get(i).equals(c)) {
        return i;
      }
    }
    return -1;
  }
  
  // @override toString
  public String toString() {
    String classes_string = "";
    for (int i = 0; i < this.classes.size(); i++) {
      classes_string += (this.classes.get(i) + ", ");
    }
    return "Student {\n"+
      "\tfirst : "+this.getFirstName()+"\n"+
      "\tlast : "+this.getLastName()+"\n"+
      "\tage : "+this.getAge()+"\n"+
      "\tgender : "+this.getGender()+"\n"+
      "\tmajor : "+this.getMajor()+"\n"+
      "\tGPA : "+this.getGPA()+"\n"+
      "\tclasses : "+classes_string+"\n"+
      "}"
      ;
  }
}