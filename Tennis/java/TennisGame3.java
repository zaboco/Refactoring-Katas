
public class TennisGame3 implements TennisGame {
    
    private int secondPlayerPoints;
    private int firstPlayerPoints;
    private String firstPlayerName;
    private String secondPlayerName;

    public TennisGame3(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String getScore() {
        String s;
        if (firstPlayerPoints < 4 && secondPlayerPoints < 4) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[firstPlayerPoints];
            return (firstPlayerPoints == secondPlayerPoints) ? s + "-All" : s + "-" + p[secondPlayerPoints];
        } else {
            if (firstPlayerPoints == secondPlayerPoints)
                return "Deuce";
            s = firstPlayerPoints > secondPlayerPoints ? firstPlayerName : secondPlayerName;
            return ((firstPlayerPoints - secondPlayerPoints)*(firstPlayerPoints - secondPlayerPoints) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.firstPlayerPoints += 1;
        else
            this.secondPlayerPoints += 1;
        
    }

}
