package launch_new_game_use_case;

public class LaunchGameRequestModel{
    private final String playerOneType;
    private final String playerTwoType;
    private final String playerOneName;
    private final String playerTwoName;
    public LaunchGameRequestModel(String playerOneType, String playerTwoType, String playerOneName, String playerTwoName) {
        this.playerOneType = playerOneType;
        this.playerTwoType = playerTwoType;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }
    public String getPlayerOneType() {
        return this.playerOneType;
    }
    public String getPlayerTwoType() {
        return this.playerTwoType;
    }
    public String getPlayerOneName() {
        return this.playerOneName;
    }
    public String getPlayerTwoName() {
        return this.playerTwoName;
    }
}
