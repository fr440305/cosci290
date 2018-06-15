// Weishu Tan, 882984689 at East Los Angeles College

import java.util.ArrayList;

public class TestStudent {
  
  // This method generates a rendom string consists
  // of captical letters with length given in the parameter.
  public static String randomString(int len) {
    String ret = "";
    for (int i = 0; i < len; i++) {
      ret += ((char)(Math.random() * ('Z'-'A') + 'A'));
    }
    return ret;
  }
  
  public static int randomInt(int lwr, int upr) {
    return ((int)(Math.random() * (upr-lwr) + (lwr)));
  }
  
  public static void main (String[] args) {
    ArrayList<Student> studentList = new ArrayList<Student>();
    
    // put:
    for (int i = 0; i < 5; i++) {
      Student a = new Student();
      a.setFirstName(randomString(8));
      a.setLastName(randomString(3));
      a.setAge(randomInt(17, 25));
      a.setGender(Person.FEMALE);
      a.setMajor(randomString(5));
      a.addCourse(new Course(randomString(5), 3));
      studentList.add(a);
    }
    
    // print:
    for (int i = 0; i < 5; i++) {
      System.out.println(studentList.get(i));
    }
  }
}