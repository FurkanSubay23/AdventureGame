package AdventureGame;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Magara",new Zombie(),"Food",3);
    }
}
