package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private Game g;
    @BeforeEach
    void setupGame() {
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
        g.roll(3);            // bonus spare rzut trzeci
        rollMany(17,0); //reszta rzutow
        assertEquals(16, g.score());
    }

    @Test
    void strikeBonusFollowedByThreeAndFourShouldScore24() {
        rollStrike();        // 10 cała ramka jednym rzutem
        g.roll(3);
        g.roll(4);
        rollMany(16,0);
        assertEquals(24, g.score());
    }
    @Test
    void bestGameShouldScore300() {
        rollMany(12,10); //12 strike z rzedu
        assertEquals(300, g.score());
    }
    private void rollStrike() {
        g.roll(10);
    }
    private void rollSpare() {
        g.roll(7);
        g.roll(3);
    }
    private void rollMany(int frame, int value){
        for (int i = 0; i < frame; i++) g.roll(value);
    }
}