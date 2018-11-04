package by.nikolay;

public class BullsAndCows {

    private int cows;
    private int bulls;


    BullsAndCows(int cows, int bulls) {
        this.cows = cows;
        this.bulls = bulls;
    }

    public void reset() {
        cows = 0;
        bulls = 0;
    }


    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }
}
