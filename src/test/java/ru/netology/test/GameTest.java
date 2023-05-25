package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.game.Player;
import ru.netology.manager.Game;
import ru.netology.manager.NotRegisteredException;

public class GameTest {
    Game registeredPlayers = new Game();

    Player player1 = new Player(1, "Jabberwock", 1084);
    Player player2 = new Player(12, "Asterius", 955);
    Player player3 = new Player(123, "Celidana", 960);
    Player player4 = new Player(2, "Kara", 955);
    Player player5 = new Player(23, "Gullinbursti", 813);
    Player player6 = new Player(234, "Bai Yeong", 776);

    @Test
    public void shouldComparePlayersEqualStrength() {
        registeredPlayers.register(player2);
        registeredPlayers.register(player4);

        int expected = 0;
        int actual = registeredPlayers.round(player2.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePlayersWinFirst() {
        registeredPlayers.register(player1);
        registeredPlayers.register(player3);

        int expected = 1;
        int actual = registeredPlayers.round(player1.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePlayersWinSecond() {
        registeredPlayers.register(player5);
        registeredPlayers.register(player6);

        int expected = 2;
        int actual = registeredPlayers.round(player6.getName(), player5.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePlayersIfOneNotRegistered() {
        registeredPlayers.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player4.getName(), player5.getName());
        });
    }

    @Test
    public void shouldComparePlayersIfBothNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player2.getName(), player6.getName());
        });
    }


}


