package use_cases.launch_new_game_use_case;

import core_entities.game_parts.*;
import core_entities.player.ComputerPlayer;
import core_entities.player.HumanPlayer;
import core_entities.player.Player;

import java.io.IOException;

public class LaunchNewGameInteractor implements LaunchGameInputBoundary{
    private final LaunchGameRequestModel inputData;
    private final LaunchGameOutputBoundary presenter;
    private final LaunchGameDataAccessObject dataAccessObject;
    private final BoardFactory factory;
    public LaunchNewGameInteractor (LaunchGameRequestModel inputData, LaunchGameOutputBoundary presenter, LaunchGameDataAccessObject dataAccessObject, BoardFactory factory) {
        this.inputData = inputData;
        this.factory = factory;
        this.dataAccessObject = dataAccessObject;
        this.presenter = presenter;
    }
    @Override
    public void createGameState() {
        Bag bag = new Bag();
        LetterRack p1rack = new LetterRack(bag, 7);
        LetterRack p2rack = new LetterRack(bag, 7);
        Player p1;
        Player p2;
        if (inputData.getPlayerOneType().equals("Human Player")) {
            p1 = new HumanPlayer(inputData.getPlayerOneName(), p1rack, 0);
        }
        else {
            p1 = new ComputerPlayer(inputData.getPlayerOneName(), p1rack, 0);
        }
        if (inputData.getPlayerTwoType().equals("Human Player")) {
            p2 = new HumanPlayer(inputData.getPlayerTwoName(), p2rack, 0);
        }
        else {
            p2 = new ComputerPlayer(inputData.getPlayerTwoName(), p2rack, 0);
        }
        GameState.setP1(p1);
        GameState.setP2(p2);
        try {
            GameState.setBoard(factory.create(dataAccessObject.createBoardMultiplierGrid()));
            presenter.updateViewModel(GameState.getBoard().getMultiplierGrid());
        }
        catch (IOException e) {
            presenter.prepareFailView("CSV File not found");
        }
    }
}
