
public class TennisGame3 implements TennisGame {

    public static final int MAXIMUM_GAME_POINTS = 4;
    public static final String[] SCORE_LABELS = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int secondPlayerPoints;
    private int firstPlayerPoints;
    private String firstPlayerName;
    private String secondPlayerName;

    public TennisGame3(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String getScore() {
        if (arePointsBelowAdvantage(firstPlayerPoints) && arePointsBelowAdvantage(secondPlayerPoints)) {
            return getIntermediateScore();
        } else {
            return getAdvantageScore();
        }
    }

    private String getAdvantageScore() {
        if (doPlayersHaveEqualPoints())
            return "Deuce";
        boolean doFistPlayerHasMorePoints = firstPlayerPoints > secondPlayerPoints;
        String leadingPlayerName = doFistPlayerHasMorePoints ? firstPlayerName : secondPlayerName;
        boolean oneOfThePlayersHasAdvantage = (firstPlayerPoints - secondPlayerPoints) * (firstPlayerPoints - secondPlayerPoints) == 1;
        String gameStatus = oneOfThePlayersHasAdvantage ? "Advantage " : "Win for ";
        return gameStatus + leadingPlayerName;
    }

    private boolean doPlayersHaveEqualPoints() {
        return firstPlayerPoints == secondPlayerPoints;
    }

    private String getIntermediateScore() {
        String firstPlayerScoreLabel;
        firstPlayerScoreLabel = SCORE_LABELS[firstPlayerPoints];
        String secondPlayerScoreLabel = doPlayersHaveEqualPoints() ? "All" : SCORE_LABELS[secondPlayerPoints];
        return firstPlayerScoreLabel + "-" + secondPlayerScoreLabel;
    }

    private boolean arePointsBelowAdvantage(int firstPlayerPoints) {
        return firstPlayerPoints < MAXIMUM_GAME_POINTS;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.firstPlayerPoints += 1;
        else
            this.secondPlayerPoints += 1;
        
    }

}
