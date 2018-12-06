package game.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    /* Class Properties */
    private List<Player> playerList = new ArrayList<>();
    private List<Dice> diceList = new ArrayList<>();
    private List<Integer> rollValues;
    private int numberOfPlayers;
    private int numberOfDice;
    private int rollScore;
    private int maxScore;
    private boolean won;
    private int turns;


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
        this.resetTurns();
    }

    /* Main Functions */
    public void start() {
        this.reset();
        System.out.println("Game Start");
    }
    public void playerRoll(Player player) {
        System.out.println("Turn: " + this.getTurns());
        System.out.println("Player: " + player.getName() + " [" + player.getScore() + "]");
        this.setRollValues(this.roll());
        this.setRollScore(scoreRoll(this.getRollValues()));
        System.out.println("Rolled: " + this.getRollValues());
        System.out.println("This Scored: " + this.getRollScore());
        player.addScore(this.getRollScore());
        this.nextTurn();
    }
    public Player getTurnPlayer(int turn) {
        // Assuming 2 players for now
        if (turn % 2 == 0) return getPlayerList().get(1);
        return getPlayerList().get(0);
    }
    public Player getThisTurnPlayer() { return this.getTurnPlayer(this.getTurns()); }
    public void run() {
        List<Player> winners;
        System.out.println("Game Start");
        while (!this.checkGameWon(this.getPlayerList())) {
            for (Player player : this.getPlayerList()) {
                this.playerRoll(player);
            }
        }
        String result = "";
        winners = this.getWinners(this.getPlayerList());
        if (winners.size() > 1) {
            for (Player winner : winners) {
                result += winner.getName() + " and ";
            }
            result = result.substring(0, result.length() - 3);
            result += "drew.";
        } else if (winners.size() == 1) {
            result = "Congratulations to " + winners.get(0).getName() + " on winning!";
        } else {
            result = "Error: No one won?";
        }
        System.out.println(result);
    }
    public void reset() {
        this.resetTurns();
        this.resetWon();
        this.resetPlayerScores();
    }

    /* Game Functions */
    // Dice Rolls
    public List<Integer> roll() {
        List<Integer> rollValues = new ArrayList<>();
        for (Dice dice : this.getDiceList()) {
            dice.randomiseValue();
            rollValues.add(dice.getValue());
        }
        int score = this.scoreRoll(rollValues);
//        System.out.println(rollValues);
//        System.out.println(score);
        return rollValues;
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
    public int getRollScore() { return this.rollScore; }
    public void setRollScore(int rollScore) { this.rollScore = rollScore; }
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
    public Player getPlayer(int number) {
        for (Player p : getPlayerList()) {
            if (p.getNumber() == number) return p;
        }
        return new Player();
    }
    public void resetPlayerScores() {
        for (Player p : this.getPlayerList()) {
            p.resetScore();
        }
    }
    public void clearPlayerList() { this.playerList.clear(); }
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
    public void setRollValues(List<Integer> rollValues) { this.rollValues = rollValues; }
    public List<Integer> getRollValues() { return this.rollValues; }

    /* Turn Functions */
    public void resetTurns() {
        this.turns = 1;
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
        return score >= this.getMaxScore();
    }
    /* Win Functions */
    public void resetWon() { this.won = false; }
    public void setGameWon() { this.won = true; }
    public void setGameWon(boolean w) { this.won = w; }
    public boolean getGameWon() { return this.won; }
    public List<Player> getWinners(List<Player> playerList) {
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
        if (this.getWinners(playerList).size() > 0) {
            this.setGameWon(true);
        } else {
            this.setGameWon(false);
        }
        return this.getGameWon();
    }
    public List<Player> getThisGameWinners() { return this.getWinners(this.getPlayerList()); }
    public boolean checkThisGameWon() { return this.checkGameWon(this.getPlayerList()); }
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
