package game.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int value;
    private int min;
    private int max;

    public Dice() {
        this.setMin(1);
        this.setMax(6);
        this.randomiseValue();
    }

    public Dice(int value) {
        this.setMin(1);
        this.setMax(6);
        this.setValue(value);
    }

    public Dice(int min, int max) {
        this.setMin(min);
        this.setMax(max);
        this.randomiseValue();
    }

    public Dice(int min, int max, int value) {
        this.setMin(min);
        this.setMax(max);
        this.setValue(value);
    }

    public void randomiseValue() {
        this.setValue(ThreadLocalRandom.current().nextInt(this.getMin(), this.getMax() + 1));
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getRandomValue() {
        this.randomiseValue();
        return this.getValue();
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public String toString() {
        String rtn = "";
        rtn += "Current Dice Value: " + this.getValue() + ", ";
        rtn += "Bounds [" + this.getMin() + "," + this.getMax() + "].";
        return rtn;
    }
}
