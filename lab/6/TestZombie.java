public class TestZombie {
  public static void main (String[] args) {
    System.out.println("Testing anoymous zombies...");
    for (int i = 0; i < 10; i ++) {
      Zombie z = new Zombie();
      System.out.println(z);
      z.reduceHp(10);
      System.out.println(z);
    }
    System.out.println("Testing zombies that have names...");
    for (int i = 0; i < 10; i ++) {
      Zombie z = new Zombie("zom" + i);
      System.out.println(z);
      z.reduceHp(10);
      System.out.println(z);
    }
    System.out.println("passed.");
  }
}