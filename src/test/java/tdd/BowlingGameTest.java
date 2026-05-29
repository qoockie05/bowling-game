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
    @Test
    void allRollsHitTwoPinsShouldScore40() {
        for (int i = 0; i < 20; i++) g.roll(2);
        assertEquals(40, g.score());
    }
    @Test
    void oneSpareFollowedByThreeShouldScore16() {
        rollSpare();          //  rzut 1 i 2
        g.roll(3);            // bonus spare rzut 3
        for (int i = 0; i < 17; i++) g.roll(0); //reszta rzutow
        assertEquals(16, g.score());
    }
    private void rollSpare() {
        g.roll(7);
        g.roll(3);
    }
}