package AdventureGame;

import java.util.Random;

public class Snake extends Monster{
    public Snake() {
        super(4, "Yılan", 3+ (int) (Math.random() * 3), 12, 0);
    }
}
