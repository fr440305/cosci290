// Weishu Tan

public class ZombieSoldier extends Obj {
    private int hp;

    public ZombieSoldier () {
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
        return "ZombieSoilder\nhp id == " + this.hp + " " + super.getId() + "\n\n";
    }
}
