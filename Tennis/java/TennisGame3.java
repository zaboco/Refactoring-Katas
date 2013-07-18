
public class TennisGame3 implements TennisGame {

    public static final int MAXIMUM_GAME_POINTS = 4;
    private int secondPlayerPoints;
    private int firstPlayerPoints;
    private String firstPlayerName;
    private String secondPlayerName;

    public TennisGame3(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String getScore() {
        String firstPlayerScoreLabel;
        boolean playersHaveEqualPoints = firstPlayerPoints == secondPlayerPoints;
        if (firstPlayerPoints < MAXIMUM_GAME_POINTS && secondPlayerPoints < MAXIMUM_GAME_POINTS) {
            String[] scoreLabels = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            firstPlayerScoreLabel = scoreLabels[firstPlayerPoints];
            String secondPlayerScoreLabel = playersHaveEqualPoints ? "All" : scoreLabels[secondPlayerPoints];
            return firstPlayerScoreLabel + "-" + secondPlayerScoreLabel;
        } else {
            if (playersHaveEqualPoints)
                return "Deuce";
            boolean fistPlayerHasMorePoints = firstPlayerPoints > secondPlayerPoints;
            String leadingPlayerName = fistPlayerHasMorePoints ? firstPlayerName : secondPlayerName;
            boolean oneOfThePlayersHasAdvantage = (firstPlayerPoints - secondPlayerPoints) * (firstPlayerPoints - secondPlayerPoints) == 1;
            String gameStatus = oneOfThePlayersHasAdvantage ? "Advantage " : "Win for ";
            return gameStatus + leadingPlayerName;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.firstPlayerPoints += 1;
        else
            this.secondPlayerPoints += 1;
        
    }

}
