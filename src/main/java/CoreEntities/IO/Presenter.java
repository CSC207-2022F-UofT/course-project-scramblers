package CoreEntities.IO;
import launch_new_game_use_case.LaunchGameOutputBoundary;
import launch_new_game_use_case.LaunchGameResponseModel;

import java.util.*;

public class Presenter implements Observer, LaunchGameOutputBoundary{
    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void updateViewModel(LaunchGameResponseModel responseModel) {
        //Write the code to update the view model based on the given String array
        //The array will contain the information regarding the squares on the board
            //Each String will correspond to a different multiplier (To be discussed later)
    }

    @Override
    public void prepareFailView(String errorMessage) {
        //Write the code to deal with a specific error message
    }
}
