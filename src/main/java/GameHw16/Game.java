package GameHw16;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String namePlayer) {
        for (Player player : players) {
            if (player.getName().equals(namePlayer)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        if (player1 == null) {
            throw new NotFoundException("Gamer with id: " + playerName1 + " not found");
        }
        Player player2 = findByName(playerName2);
        if (player2 == null) {
            throw new NotFoundException("Gamer with id: " + playerName2 + " not found");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else return 0;
    }
}
