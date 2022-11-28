package Computer_player_place_word_user_story;

import CoreEntities.Player.*;
import core_entities.game_parts.*;

import java.io.IOException;

public class ComPlaceWordInteractor implements ComPlaceWordInputBoundary {

    private final ComPlaceWordInputData inputData;

    public ComPlaceWordInteractor(ComPlaceWordInputData inputData){
        this.inputData = inputData;
    }


    @Override
    public void makemove() {
        LetterRack rack = inputData.getRack();
        String name = inputData.getName();
        int score = inputData.getScore();
        Board currBoard = inputData.getCurrBoard();
        ComputerPlayer p = new ComputerPlayer(name, rack, score);
        p.generateMove(currBoard);
    }
}
