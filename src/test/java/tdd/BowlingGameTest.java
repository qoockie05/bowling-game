package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private Game g;

    @Test
    void worstGameShouldScoreZero() {
        Game g = new Game();
        for (int i = 0; i < 20; i++) g.roll(0);
        assertEquals(0, g.score());
    }
    @Test
    void allRollsHitTwoPinsShouldScore40() {
        Game g = new Game();
        for (int i = 0; i < 20; i++) g.roll(2);
        assertEquals(40, g.score());
    }
}