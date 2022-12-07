package launch_new_game_use_case;

public class LaunchGameResponseModel {
    private final String [][] boardLayout;
    private final char [] letterRack;
    private final int score;
    public LaunchGameResponseModel (String [][] boardLayout, char [] letterRack, int score) {
        this.boardLayout = boardLayout;
        this.letterRack = letterRack;
        this.score = score;
    }
    public String[][] getBoardLayout() {
        return this.boardLayout;
    }
    public char[] getLetterRack(){return this.letterRack;}
    public int getScore() {
        return this.score;
    }
}
