package Homework1;

/**
 * Класс для описания игрока
 */
public class Player {
    private String name;
    private boolean risk;

    public Player(String name, boolean risk) {
        this.name = name;
        this.risk = risk;
    }

    public String getName() {
        return name;
    }

    public boolean getRisk() {
        return risk;
    }
}
