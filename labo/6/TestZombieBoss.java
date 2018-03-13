public class TestZombieBoss {
    public static void main (String[] args) {
        ZombieBoss zb = new ZombieBoss();
        System.out.println(zb);
        System.out.println("ZombieBoss.getHp(): " + zb.getHp());
        System.out.println("ZombieBoss.reduceHp(): " + zb.reduceHp(10));
        System.out.println(zb);
        System.out.println("passed");
    }
}
