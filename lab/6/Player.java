public class Player {
	private int hp; // life
	public Player () {
		this.hp = 100;
	}
	
	// this function will not check if z is null.
	// if z is null, it will throw a NullPointerException.
	public void hurtZombie (Zombie z, int hurt_val) {
		z.reduceHp(10);
	}
}

