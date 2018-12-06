package game.domain;

public class Player {
    private String name;
    private int number;
    private int score;
    public Player() {
//        this.setName("New Player");
//        this.setNumber(0);
//        this.setScore(0);
        this("New Player", 0);
    }
    public Player(String name, int number) {
        this.setName(name);
        this.setNumber(number);
        this.setScore(0);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void addScore(int points) {
        this.score += points;
    }
    public void resetScore() {
        this.score = 0;
    }
    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
    public int getScore() {
        return this.score;
    }
    public String toString() {
        String rtn = "";
        rtn += "Player " + this.getNumber() + ", ";
        rtn += "Name: " + this.getName() + ", ";
        rtn += "Current Score: " + this.getScore() + ".";
        return rtn;
    }
}
