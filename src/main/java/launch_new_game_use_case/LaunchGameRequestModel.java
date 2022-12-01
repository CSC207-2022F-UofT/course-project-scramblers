package launch_new_game_use_case;

public class LaunchGameRequestModel{
    private final String playerOneType;
    private final String playerTwoType;
    private final String playerOneName;
    private final String playerTwoName;
    private final String boardCsvFile;

    /**
     * This represents the default constructor, which will assume the default values for some inputs (i.e. no information provided)
     */
    public LaunchGameRequestModel(String playerOneType, String playerTwoType, String playerOneName, String playerTwoName) {
        this.playerOneType = playerOneType;
        this.playerTwoType = playerTwoType;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.boardCsvFile = "src/main/java/default_reference_values/board-data.csv";
    }
    public LaunchGameRequestModel(String playerOneType, String playerTwoType, String playerOneName, String playerTwoName, String csvPath) {
        this.playerOneType = playerOneType;
        this.playerTwoType = playerTwoType;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.boardCsvFile = csvPath;
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
    public String getBoardCsvFile() {
        return this.boardCsvFile;
    }
}
