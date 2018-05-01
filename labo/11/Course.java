// Weishu Tan, 882984689 at East Los Angeles College

// This class describe course that student takes.

public class Course {
  private String name;
  private int units;
  
  public Course () {
    this.name = "undefined";
    this.units = 0;
  }
  
  // this constructor is not requried,
  // but it is helpful for testing.
  public Course (String name, int units) {
    this.name = name;
    this.units = units;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getUnits() {
    return this.units;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setUnits(int units) {
    this.units = units;
  }
  
  // check if a course is identical to another course.
  public boolean equals (Course that) {
    return (this.name.equals(that.name) && this.units == that.units);
  }
  
  public String toString() {
    return "Course{name : "+this.name+", units : "+this.units+"}";
  }
}