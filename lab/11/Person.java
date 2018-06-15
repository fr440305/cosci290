// Weishu Tan, 882984689 at East Los Angeles College

public class Person {
  private int age;
  private String first;
  private String gender; // use string here bacause we have so many genders.
  private String last;
  
  // "builtin" genders:
  public static final String MALE = "male";
  public static final String FEMALE = "female";
  public static final String UNDEF = "undefined";
  
  public Person () {
    this.first = "undefined";
    this.last = "undefined";
    this.gender = Person.UNDEF;
  }
  
  public String toString () {
    return "Person {\n"+
      "\tfirst name : " + this.first + "\n"+
      "\tlast name : " + this.last + "\n"+
      "\tage : " + this.age + "\n"+
      "\tgender : " + this.gender + "\n}";
  }
  
  public String getFirstName() {
    return this.first;
  }
  
  public void setFirstName(String f) {
      this.first = f;
  }
  
  public String getLastName() {
    return this.last;
  }
  
  public void setLastName(String l) {
    this.last = l;
  }
  
  public int getAge () {
    return this.age;
  }
  
  public void setAge (int a) {
    this.age = a;
  }
  
  public String getGender() {
    return this.gender;
  }
  
  public void setGender(String g) {
    this.gender = g;
  }
}