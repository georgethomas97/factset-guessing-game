package com.game.guesser.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameClientTest {

    GameClient gameClient = new GameClient();

    @Test
    public void testStartGame() {

        String input = "a -1 11 4 6 7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gameClient.startGame();
        Assertions.assertNotNull(gameClient.getGuessValue());


    }
}
