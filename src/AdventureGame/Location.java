package AdventureGame;

import java.util.Scanner;

public abstract class Location {
   private Player player;
    private String name;
    protected Scanner input = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }
    public abstract boolean onLocation();   // Ölüm kalım anlama methodu.




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
