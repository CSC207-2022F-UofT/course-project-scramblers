package use_cases.place_word_refill_user_story;

import core_entities.game_parts.*;
import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary{

    final PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary;
    final tileCollector tileCollector;
    final boardChecker boardChecker;
    final letterVerifier letterVerifier;

    /**
     * Use Case Interactor for placing a word if valid and possible, and refilling the player's LetterRack. Implements
     * the Facade design pattern by delegating the tasks of collecting the tiles to place, check of the board space,
     * and the verification of the word and tiles.
     * @param presenter Presenter that implements PlaceWordRefillOutputBoundary
     */
    public PlaceWordRefillInteractor(PlaceWordRefillOutputBoundary presenter) {
        this.placeWordRefillOutputBoundary = presenter;
        this.tileCollector = new tileCollector(); // Delegating the task of collecting the tiles to place
        this.boardChecker = new boardChecker(); // Delegating the task of checking the board space
        this.letterVerifier = new letterVerifier(); // Delegating the task of verifying the word and tiles
    }

    /**
     * Place the word if valid and possible, and then refill the LetterRack to comply with the rules. The Tiles of the
     * Board and Player's LetterRack are first verified to see if these Tiles are available. The board is then checked
     * if the area is empty, and if any existing Tiles on the board are in the correct spot. Then, the tiles are
     * placed on the board, and the LetterRack is refilled.
     *
     * @return true if the word is successfully being placed
     */
    @Override
    public boolean placeWordRefill(PlaceWordRefillRequestModel requestModel) {
        Board board = GameState.getBoard();
        ArrayList<Tile> existingOnBoard = new ArrayList<>();
        if (!letterVerifier.verifyLetters(GameState.getCurrentPlayer(), requestModel.word, requestModel.c1,
                requestModel.c2, existingOnBoard)) {
            placeWordRefillOutputBoundary.prepareFailView("Letters are not available for this word to be placed.");
            return false;
        }
        if (!boardChecker.boardCheck(requestModel.word, requestModel.c1, requestModel.c2)){
            placeWordRefillOutputBoundary.prepareFailView("Placement of word is not valid.");
            return false;
        }
        Tile[] toPlace = tileCollector.collectTiles(GameState.getCurrentPlayer(), requestModel.word, existingOnBoard);
        board.placeTiles(toPlace, requestModel.c1, requestModel.c2);
        GameState.getCurrentPlayer().getRack().discardLetters(requestModel.word);
        GameState.getCurrentPlayer().getRack().refill();
        GameState.getCurrentPlayer().addScore(getScoreOfWord(requestModel.word, GameState.getBoard().getMultiplierGrid(), requestModel.c1, requestModel.c2));
        placeWordRefillOutputBoundary.updateViewModel(new PlaceWordRefillResponseModel(true, requestModel.word,
                GameState.getCurrentPlayer(), GameState.getCurrentPlayer().getScore()));
        return true;
    }
    private int getScoreOfWord(String word, String [][] boardGrid, Coordinate c1, Coordinate c2) {
        int wordMultiplier = 1;
        int currentScore = 0;
        String currentMultiplier;
        boolean horizontal = c1.getXCoordinate() < c2.getXCoordinate();
        for(int i = 0; i < word.length(); i++) {
            Tile t = new Tile(Character.toUpperCase(word.charAt(i)));
            if (horizontal) {
                currentMultiplier = boardGrid[c1.getXCoordinate() + i][c1.getYCoordinate()];
                if (currentMultiplier.equals("W3")) {
                    wordMultiplier *= 3;
                    currentScore += t.getValue();
                }
                else if (currentMultiplier.equals("W2")) {
                    wordMultiplier *= 2;
                    currentScore += t.getValue();
                }
                else if (currentMultiplier.equals("L3")) {
                    currentScore += 3 * t.getValue();
                }
                else if (currentMultiplier.equals("L2")) {
                    currentScore += 2 * t.getValue();
                }
                else {
                    currentScore += t.getValue();
                }
            }
            else {
                currentMultiplier = boardGrid[c1.getXCoordinate()][c1.getYCoordinate() + i];
                if (currentMultiplier.equals("W3")) {
                    wordMultiplier *= 3;
                    currentScore += t.getValue();
                }
                else if (currentMultiplier.equals("W2")) {
                    wordMultiplier *= 2;
                    currentScore += t.getValue();
                }
                else if (currentMultiplier.equals("L3")) {
                    currentScore += 3 * t.getValue();
                }
                else if (currentMultiplier.equals("L2")) {
                    currentScore += 2 * t.getValue();
                }
                else {
                    currentScore += t.getValue();
                }
            }
        }
        return currentScore * wordMultiplier;
    }
}
