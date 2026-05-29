package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private Game g;
    @BeforeEach
    void setUp() {
        g = new Game();
    }
    @Test
    void worstGameShouldScoreZero() {
        for (int i = 0; i < 20; i++) g.roll(0);
        assertEquals(0, g.score());
    }
}