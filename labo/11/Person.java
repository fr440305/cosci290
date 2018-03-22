public class Person {
  private String first;
  private String last;
  private int gender;
  private int age;
  public static final int MALE = 1;
  public static final int FEMALE = 0;
  public static final int UNDEF = 2;
  
  public Person () {
    this.first = "Firstname";
    this.last = "Lastname";
    this.gender = Person.UNDEF;
  }
  
  public String toString () {
    String gender_string = "";
    switch (this.gender) {
      case Person.MALE: gender_string = "male"; break;
      case Person.FEMALE: gender_string = "female"; break;
      case Person.UNDEF: gender_string = "undefined"; break;
    }
    return "Person {\n\tfirst last age gender = " + this.first + " " + this.last + " " + this.age + " " + gender_string + "\n}";
  }
  
  public String getFirstName() {
    return this.first;
  }
  
  public boolean setFirstName(String f) {
    if (f.length() > 0 && f.charAt(0) >= 'A' && f.charAt(0) <= 'Z') {
      this.first = f;
      return true;
    } else {
      return false;
    }
  }
  
  public String getLastName() {
    return this.last;
  }
  
  public boolean setLastName(String l) {
    if (l.length() > 0 && l.charAt(0) >= 'A' && l.charAt(0) <= 'Z') {
      this.last = l;
      return true;
    } else {
      return false;
    }
  }
  
  public int getAge () {
    return this.age;
  }
  
  public boolean setAge (int a) {
    if (a >= 0) {
      this.age = a;
      return true;
    } else {
      return false;
    }
  }
  
  public int getGender() {
    return this.gender;
  }
  
  public boolean setGender(int g) {
    if (g >= 0 && g <= 2) {
      this.gender = g;
      return true;
    } else {
      return false;
    }
  }
  
}