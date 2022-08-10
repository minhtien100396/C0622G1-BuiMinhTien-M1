package ss8_refactoring.bai_tap.bai_1.model;

public class TennisGame {
    public static String getScore(int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";
        int tempScore = 0;
        if (scoreOfPlayer1 == scoreOfPlayer2) {
            score = draw(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            score = checkAdventagePlayer(scoreOfPlayer1, scoreOfPlayer2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scoreOfPlayer1;
                else {
                    score += "-";
                    tempScore = scoreOfPlayer2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
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
}
