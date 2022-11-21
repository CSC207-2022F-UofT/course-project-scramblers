package CoreEntities.IO;

public class TurnController {
    private TurnBuilderBoundary makeword;

    public TurnController(TurnBuilderBoundary makeword) {
        this.makeword = makeword;
    }

    public void makeHumanWord() {
        this.makeword.makeHumanWord();
    }

    public void makeComputerWord() {
        this.makeword.makeComputerWord();
    }

}


