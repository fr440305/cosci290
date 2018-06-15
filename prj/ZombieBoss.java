// Weishu Tan

public class ZombieBoss extends Obj {
    private int hp;

    public ZombieBoss () {
        this.hp = 100;
    }

    public void hurtPlayer (Player p) {
        p.reduceHp(10);
    }

    public int getHp () {
        return this.hp;
    }

    public int reduceHp (int d) {
        this.hp -= d;
        if (this.hp < 0) this.hp = 0;
        return this.hp;
    }

    public String toString () {
        return "ZombieBoss\nhp id == " + this.hp + " " + super.getId() + "\n\n";
    }
}
