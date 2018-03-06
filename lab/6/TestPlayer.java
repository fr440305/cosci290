public class TestPlayer {
    public static void main (String[] args) {
  		Player p = new Player();
	  	Zombie[] z_arr = new Zombie[10];
	  	for (int i = 0; i < 10; i++) {
	  		z_arr[i] = new Zombie();
	  		p.hurtZombie(z_arr[i], 10);
	  		System.out.println(z_arr[i]);
      }
      System.out.println("passed.");
    }
}
