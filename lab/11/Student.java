// Weishu Tan, 882984689 at East Los Angeles College

import java.util.ArrayList;

public class Student extends Person {
  private String major;
  private double gpa;
  private ArrayList<Course> courses;
  
  public Student() {
    super();
    this.major = "";
    this.gpa = 0;
    this.courses = new ArrayList<Course>();
  }
  
  public String getMajor() {
    return this.major;
  }
  
  public void setMajor(String m) {
    this.major = m;
  }
  
  public double getGPA () {
    return this.gpa;
  }
  
  public void setGPA (double g) {
    this.gpa = g;
  }
  
  public Student addCourse (Course c) {
    this.courses.add(c);
    return this;
  }
  
  // this method delete a course which is
  // identical to the parameter from the list.
  // If there is no identical course in the list,
  // this method returns false
  // without any modification to the student object.
  public boolean delCourse (Course c) {
    int i;
    if ((i = this.findCourse(c)) != -1) {
      this.courses.remove(i);
      return true;
    } else {
      return false;
    }
  }
  
  // this method returns the index of the course
  // identical to the parameter from the course list.
  // If there is no identical course, this method returns -1.
  public int findCourse (Course c) {
    for (int i = 0; i < this.courses.size(); i++) {
      if (this.courses.get(i).equals(c)) {
        return i;
      }
    }
    return -1;
  }
  
  public String toString() {
    String classes_string = "";
    for (int i = 0; i < this.courses.size(); i++) {
      classes_string += ("\n\t\t" + this.courses.get(i).toString());
    }
    return "Student {\n"+
      "\tfirst : "+this.getFirstName()+"\n"+
      "\tlast : "+this.getLastName()+"\n"+
      "\tage : "+this.getAge()+"\n"+
      "\tgender : "+this.getGender()+"\n"+
      "\tmajor : "+this.getMajor()+"\n"+
      "\tGPA : "+this.getGPA()+"\n"+
      "\tclasses : "+classes_string+"\n"+
      "}";
  }
}