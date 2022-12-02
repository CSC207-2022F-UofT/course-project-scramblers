package launch_new_game_use_case;

public class LaunchGameResponseModel {
    private final String [][] boardLayout;
    private final char [] letterRack;
    public LaunchGameResponseModel (String [][] boardLayout, char [] letterRack) {
        this.boardLayout = boardLayout;
        this.letterRack = letterRack;
    }
    public String[][] getBoardLayout() {
        return this.boardLayout;
    }
    public char[] getLetterRack(){return this.letterRack;}
}
