package MontiHall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameTest {

    @Test
    void checkNotRiskStrategy() {
        //given
        Player player = new Player("Игрок", false);
        int wins = 0;
        int trials = 1000;

        //when
        for (int i = 0; i < trials; i++) {
            Game game = new Game(player, getShuffledDoors());
            Door door = game.playRound();
            if (door.isPrize()) {
                wins++;
            }
        }

        //then
        double winRate = (double) wins / trials;
        Assertions.assertTrue(winRate < 0.4, "Win rate should be less than 40% for non-risk strategy");
    }

    @Test
    void checkRiskStrategy() {
        //given
        Player player = new Player("Игрок", true);
        int wins = 0;
        int trials = 1000;

        //when
        for (int i = 0; i < trials; i++) {
            Game game = new Game(player, getShuffledDoors());
            Door door = game.playRound();
            if (door.isPrize()) {
                wins++;
            }
        }

        //then
        double winRate = (double) wins / trials;
        Assertions.assertTrue(winRate > 0.6, "Win rate should be more than 60% for risk strategy");
    }

    private List<Door> getShuffledDoors() {
        List<Door> doors = Arrays.asList(new Door(true), new Door(false), new Door(false));
        Collections.shuffle(doors);
        return doors;
    }
}
