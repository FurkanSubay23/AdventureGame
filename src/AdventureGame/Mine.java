package AdventureGame;

import java.util.Random;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super(player,"Maden", new Snake(),"treasury", 5);
    }
}
