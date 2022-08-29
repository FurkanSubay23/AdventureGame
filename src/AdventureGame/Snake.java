package AdventureGame;

import java.util.Random;

public class Snake extends Monster{
    public Snake() {
        super(4, "Yilan", 3+ (int) (Math.random() * 4), 12, 0);
    }
}
