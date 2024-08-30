package GameHw16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {
    @Test
    public void testFirstPlayer() {
        Player player1 = new Player(1, "Oleg", 150);
        Player player2 = new Player(2, "Ivan", 120);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Oleg", "Ivan");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayer() {
        Player player1 = new Player(1, "Oleg", 100);
        Player player2 = new Player(2, "Ivan", 130);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Oleg", "Ivan");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStrengthEquals() {
        Player player1 = new Player(1, "Oleg", 130);
        Player player2 = new Player(2, "Ivan", 130);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Oleg", "Ivan");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNotExists() {
        Player player1 = new Player(1, "Oleg", 130);
        Player player2 = new Player(2, "Ivan", 130);
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotFoundException.class,
                () -> game.round("Oleg", "Ivan"));
    }

    @Test
    public void testSecondPlayerNotExists() {
        Player player1 = new Player(1, "Oleg", 130);
        Player player2 = new Player(2, "Ivan", 130);
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotFoundException.class,
                () -> game.round("Oleg", "Ivan"));
    }
}
