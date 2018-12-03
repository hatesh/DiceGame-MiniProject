package game.domain;

public class Tester {
    public static void main(String[] args) {
        Game game = new Game();
        game.newPlayer("Tim", 1);
        game.newPlayer("John", 2);
        game.run();
    }
}
