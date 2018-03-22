public class TestStudent {
  
  public static void main (String[] args) {
    Student a = new Student();
    a.setFirstName("Weishu");
    a.setLastName("Tan");
    a.setAge(20);
    a.setGender(Person.MALE);
    
    a.setMajor("Computer Science");
    
    a.addClass("COSCI 290");
    a.addClass("PHYSICS 11");
    a.addClass("MATH 262");
    a.addClass("ENGLISH 101");

    System.out.println(a);
  }
}