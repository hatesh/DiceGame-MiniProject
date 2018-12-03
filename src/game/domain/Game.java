package game.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    /* Class Properties */
    private List<Player> playerList = new ArrayList<>();
    private List<Dice> diceList = new ArrayList<>();
    private int numberOfPlayers;
    private int numberOfDice;
    private int maxScore;
    private int turns;
    private boolean won;

    /* Constructors */
    // Default
    public Game() {
        this(2, 3, 30);
    }
    // Custom Max Score
    public Game(int maxScore) {
        this(2, 3, maxScore);
    }
    // Custom
    public Game(int nop, int nod, int maxScore) {
        this.setNumberOfPlayers(nop);
        this.setNumberOfDice(nod);
        this.setMaxScore(maxScore);
        this.initDice();
    }

    /* Main Functions */
    public void run() {

    }
    public void reset() {
        this.resetTurns();
        this.resetWon();
        this.resetScores(this.getPlayerList());
    }

    /* Game Functions */
    // Dice Rolls
    public void roll() {
        List<Integer> rollValues = new ArrayList<>();
        for (Dice dice : this.getDiceList()) {
            dice.randomiseValue();
            rollValues.add(dice.getValue());
        }
        int score = this.scoreRoll(rollValues);
        System.out.println(rollValues);
        System.out.println(score);
    }
    // Dice Scoring
    public int scoreRoll(List<Integer> rollValues) {
        Integer score;
        if (this.checkAllSame(rollValues)) {
            score = 18;
        } else if (this.scoreIfPair(rollValues) > 0) {
            score = this.scoreIfPair(rollValues);
        } else {
            score = 1;
        }
        return score;
    }
    public boolean checkAllSame(List<Integer> rollValues) {
        boolean check = true;
        for(int i = 0; i < rollValues.size(); i++) {
            for(int j = 0; j < rollValues.size(); j++) {
                if (!rollValues.get(j).equals(rollValues.get(i))) check = false;
            }
        }
        return check;
    }
    public int scoreIfPair(List<Integer> rollValues) {
        int pair = 0;
        for(int i = 0; i < rollValues.size(); i++) {
            for(int j = 0; j < rollValues.size(); j++) {
                if (rollValues.get(j).equals(rollValues.get(i)) && i != j) {
                    pair = rollValues.get(j) * 2;
                }
            }
        }
        return pair;
    }


    /* Player Functions */
    // Player List
    public void addPlayer(Player player) {
        playerList.add(player);
    }
    public void newPlayer(String name, int number) {
        Player player = new Player(name, number);
        this.addPlayer(player);
    }
    public List<Player> getPlayerList() {
        return this.playerList;
    }
    // Number of Players
    public void setNumberOfPlayers(int nop) {
        this.numberOfPlayers = nop;
    }
    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    /* Dice Functions */
    // Dice List
    public void addDice(Dice dice) {
        this.diceList.add(dice);
    }
    public void newDice() {
        Dice dice = new Dice(1, 6);
        this.addDice(dice);
    }
    public void initDice() {
        for (int i = 0; i < this.getNumberOfDice(); i++) {
            this.newDice();
        }
    }

    public List<Dice> getDiceList() {
        return this.diceList;
    }
    // Number of Dice
    public void setNumberOfDice(int nod) {
        this.numberOfDice = nod;
    }
    public int getNumberOfDice() {
        return this.numberOfDice;
    }

    /* Turn Functions */
    public void resetTurns() {
        this.turns = 0;
    }
    public void nextTurn() {
        this.turns += 1;
    }
    public int getTurns() {
        return this.turns;
    }
    public void setTurns(int turns) {
        this.turns = turns;
    }

    /* Score Functions */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
    public int getMaxScore() {
        return this.maxScore;
    }
    public boolean passedMaxScore(int score) {
        return score > this.getMaxScore();
    }
    public List<Player> resetScores(List<Player> playerList) {
        for (Player player : playerList) {
            player.setScore(0);
        }
        return playerList;
    }

    /* Win Functions */
    public void resetWon() { this.won = false; }
    public void setGameWon() { this.won = true; }
    public void setGameWon(boolean w) { this.won = w; }
    public boolean getGameWon() { return this.won; }
    public List<Player> checkWinners(List<Player> playerList) {
        List<Player> winners = new ArrayList<>();
        for (Player player : playerList) {
            if (passedMaxScore(player.getScore())) winners.add(player);
        }
        if (winners.size() > 1) {
            System.out.println("It's a draw");
            this.setGameWon();
        } else if (winners.size() == 1) {
            System.out.println("We have a winner");
            this.setGameWon();
        } else {
            System.out.println("No winner yet");
        }
        return winners;
    }
    public boolean checkGameWon(List<Player> playerList) {
        if (this.checkWinners(playerList).size() > 0) {
            this.setGameWon(true);
        } else {
            this.setGameWon(false);
        }
        return this.getGameWon();
    }
    public Player getPlayerInLead(List<Player> playerList) {
        Player winning = new Player();
        for(Player player : playerList) {
            if (player.getScore() > winning.getScore()) {
                winning = player;
            }
        }
        return winning;
    }
}