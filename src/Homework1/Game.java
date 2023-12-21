package Homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс для реализации игры
 */
public class Game {

    private Player player;
    private List<Door> doors;
    private Random random = new Random();

    public Game(Player player, List<Door> doors) {
        this.player = player;
        this.doors = new ArrayList<>(doors);
    }

    public Door playRound() {
        int chosenDoorIndex = player.getRisk() ? random.nextInt(3) : 0;
        Door chosenDoor = doors.get(chosenDoorIndex);

        for (int i = 0; i < doors.size(); i++) {
            if (i != chosenDoorIndex && !doors.get(i).isPrize()) {
                doors.remove(i);
                break;
            }
        }

        if (player.getRisk() && doors.size() > 1) {
            doors.remove(chosenDoor);
            chosenDoor = doors.get(random.nextInt(doors.size()));
        }

        return chosenDoor;
    }
}
