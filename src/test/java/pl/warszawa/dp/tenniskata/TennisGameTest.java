package pl.warszawa.dp.tenniskata;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * pl.warszawa.dp.tenniskata.TennisGameTest
 *
 * @author Warszawa-DP Study Group, 2010-09-14
 */
@Test
public class TennisGameTest {
    private TennisGame game;

    @BeforeMethod
    private void setup() {
        game = new TennisGame();
    }

    public void bothPlayersShouldHaveLoveAtStart() {
        //given
        //when
        String score = game.getTextScore();
        //then
        assertEquals(score, "0:0");
    }

    public void test15_0() {
        setPoints(1, 0);

        assertTextScoreAndWinner("15:0", GameStatus.NONE);
    }

    public void test15_15() {
        setPoints(1, 1);

        assertTextScoreAndWinner("15:15", GameStatus.NONE);
    }

    public void test40_0() {
        setPoints(3, 0);

        assertTextScoreAndWinner("40:0", GameStatus.NONE);
    }

    public void shouldWinWhenBallWonAt40_0() {
        setPoints(4, 0);

        assertTextScoreAndWinner("50:0", GameStatus.FIRST_WON);
    }

    public void shouldBeDuiceAt40_40() {
        setPoints(3, 3);

        assertTextScoreAndWinner(TennisGame.DUICE, GameStatus.NONE);
    }

    @Test(enabled = false)
    public void shouldGainAdvantageWhenDuiceAndFirstPlayerScores() {
        setPoints(4, 3);
        //TODO
    }

    private void assertTextScoreAndWinner(String textScore, GameStatus status) {
        assertEquals(game.getTextScore(), textScore);
        assertEquals(game.getWinner(), status);
    }

    private void setPoints(int scoreA, int scoreB) {
        for (int i=0; i<scoreA; i++) {
            game.firstPlayerScores();
        }
        for (int i=0; i<scoreB; i++) {
            game.secondPlayerScores();
        }
    }
}
