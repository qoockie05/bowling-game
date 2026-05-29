package tdd;


public class Game {
    final private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }
    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[i] == 10) { // strike bonus
                score += 10 + rolls[i + 1] + rolls[i + 2]; //dodaje 10 punktow i dwa rzuty dodatkowo jako bonus
                i++; //przesuwam o jeden
            }
           else if (rolls[i] + rolls[i + 1] == 10) { //spare bonus
                score += 10 + rolls[i + 2]; //dodaje  10 punktow i wartosc nastepnego rzutu
                i += 2; //przesuwam o dwa
            } else {
                score += rolls[i] + rolls[i + 1]; //zwykly rzut
                i += 2;
            }
        }
        return score;
    }
}