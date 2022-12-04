package use_cases.reload_game_use_case;

import core_entities.game_parts.LetterRack;
import core_entities.game_parts.Square;

public class ReloadGameResponseModel {

    private final String [][] multiplierGrid;
    private final char [][] characterGrid;
    private final char [] letterRack;

    public ReloadGameResponseModel (String [][] multiplierGrid, char [][] characterGrid, char [] letterRack) {
        this.multiplierGrid = multiplierGrid;
        this.characterGrid = characterGrid;
        this.letterRack = letterRack;
    }

    public String[][] getMultiplierGrid() {
        return multiplierGrid;
    }

    public char[][] getCharacterGrid() {
        return characterGrid;
    }

    public char[] getLetterRack() {
        return letterRack;
    }
}
