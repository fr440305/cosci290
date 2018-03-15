public class Player extends Hurtable {
    private int hp; // life
    public Player () {
	this.hp = 100;
    }

    public int getHp () {
       return this.hp;
    }

    public int reduceHp (int d) {
        this.hp -= d;
        if (this.hp < 0) this.hp = 0;
        return this.hp;
    }

    public String toString() {
        return "Player\nhp:" + this.hp + "\n\n";
    }
}

