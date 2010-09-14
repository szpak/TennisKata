package pl.warszawa.dp.tenniskata;

/**
 * pl.warszawa.dp.tenniskata.TennisGame
 *
 * @author Warszawa-DP Study Group, 2010-09-14
 */
public class TennisGame {
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private int[] scores = {0,15,30,40,50};
    static final String DUICE = "duice";

    public String getTextScore() {
        if(firstPlayerScore == secondPlayerScore && secondPlayerScore > 2){
            return DUICE;
        }
        return renderScore(firstPlayerScore) + ":" + renderScore(secondPlayerScore);
    }

    private int renderScore(int playerScore) {
        return scores[playerScore];
    }

    public void firstPlayerScores() {
        firstPlayerScore++;
    }

    public GameStatus getWinner() {
        if(firstPlayerScore > 3){
             return GameStatus.FIRST_WON;
        }

        return GameStatus.NONE;
    }

    public void secondPlayerScores() {
        secondPlayerScore++;
    }
}
