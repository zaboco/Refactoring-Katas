
public class TennisGame1 implements TennisGame {
    
    private static final String ALL = "All";
	private static final String DASH = "-";
	private static final String DEUCE = "Deuce";
	private static final String FORTY = "Forty";
	private static final String THIRTY = "Thirty";
	private static final String FIFTEEN = "Fifteen";
	private static final String LOVE = "Love";
	private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
		if (playerName == player1Name)
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (playerOneScore==playerTwoScore)
        {
            String dashAll = DASH + ALL;
			switch (playerOneScore)
            {
                case 0:
                        score = LOVE + dashAll;
                    break;
                case 1:
                        score = FIFTEEN + dashAll;
                    break;
                case 2:
                        score = THIRTY + dashAll;
                    break;
                case 3:
                        score = FORTY + dashAll;
                    break;
                default:
                        score = DEUCE;
                    break;
            }
        }
        else if (playerOneScore>=4 || playerTwoScore>=4)
        {
            int minusResult = playerOneScore-playerTwoScore;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = playerOneScore;
                else { score+=DASH; tempScore = playerTwoScore;}
                switch(tempScore)
                {
                    case 0:
                        score+=LOVE;
                        break;
                    case 1:
                        score+=FIFTEEN;
                        break;
                    case 2:
                        score+=THIRTY;
                        break;
                    case 3:
                        score+=FORTY;
                        break;
                }
            }
        }
        return score;
    }
}
