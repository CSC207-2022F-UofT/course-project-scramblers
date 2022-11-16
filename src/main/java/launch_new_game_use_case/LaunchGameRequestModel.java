package launch_new_game_use_case;

public class LaunchGameRequestModel{
    private final String playerOneType;
    private final String playerTwoType;
    public LaunchGameRequestModel(String playerOneType, String playerTwoType) {
        this.playerOneType = playerOneType;
        this.playerTwoType = playerTwoType;
    }
    public String getPlayerOneType() {
        return this.playerOneType;
    }
    public String getPlayerTwoType() {
        return this.playerTwoType;
    }
}
