package ss8_refactoring.bai_tap.bai_1.model;

public class TennisGame {

    public static final int SCORE_0 = 0;
    public static final int SCORE_1 = 1;
    public static final int SCORE_2 = 2;
    public static final int SCORE_3 = 3;

    public static String getScore(int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";
        int tempScore = 0;
        if (scoreOfPlayer1 == scoreOfPlayer2) {
            score = draw(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            score = checkAdventagePlayer(scoreOfPlayer1, scoreOfPlayer2);
        } else {
            score = checkAdventagePlayer2(scoreOfPlayer1, scoreOfPlayer2);
        }
        return score;
    }

    public static String draw(int scoreOfPlayer1) {
        String score = "";
        switch (scoreOfPlayer1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public static String checkAdventagePlayer(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public static String checkAdventagePlayer2(int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scoreOfPlayer1;
            } else {
                score += "-";
                tempScore = scoreOfPlayer2;
            }
            switch (tempScore) {
                case SCORE_0:
                    score += "Love";
                    break;
                case SCORE_1:
                    score += "Fifteen";
                    break;
                case SCORE_2:
                    score += "Thirty";
                    break;
                case SCORE_3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
