package launch_new_game_use_case;

public class LaunchGameResponseModel {
    private final String [][] boardLayout;
    public LaunchGameResponseModel (String [][] boardLayout) {
        this.boardLayout = boardLayout;
    }
    public String[][] getBoardLayout() {
        return this.boardLayout;
    }
}
