public class Arr5x5 {

    // This is the array inside the class.
    private int[][] arr;

    public Arr5x5(int lwr, int upr) {
        this.arr = new int[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                this.arr[row][col] = this.randomInteger(lwr, upr);
            }
        }
    }

    // Generate a random integer >= lwr and <= upr.
    public int randomInteger(int lwr, int upr) {
        int range = upr - lwr + 1;
        return (int)(lwr + Math.random() * range) ;
    }

    public String toString() {
        String ret = "";
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                ret += (this.arr[row][col] + " ");
            }
            ret += ("\n");
        }
        return ret;
    }

}

