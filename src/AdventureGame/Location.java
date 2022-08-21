package AdventureGame;

public abstract class Location {
    Player player;
    private String name;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
