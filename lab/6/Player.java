public class Player {
	public int hp; // life
	public Player () {
		this.hp = 100;
	}
	
	// this function will not check if z is null.
	// if z is null, it will throw a NullPointerException.
	// if z is killed, then this func will ret true.
	public boolean hurtZombie (Zombie z, int hurt_val) {
		z.hp -= hurt_val;
		return (z.hp <= 0);
	}
}

