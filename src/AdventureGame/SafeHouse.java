package AdventureGame;

public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Guvenli ev");

    }
    @Override
    public boolean onLocation() {
        System.out.println("Guvenli evdesiniz");
        System.out.println("Caniniz yenilendi");
        return true;
    }
}
