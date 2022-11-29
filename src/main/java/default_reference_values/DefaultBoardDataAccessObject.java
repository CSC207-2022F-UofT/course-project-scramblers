package default_reference_values;

import launch_new_game_use_case.LaunchGameDataAccessObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DefaultBoardDataAccessObject implements LaunchGameDataAccessObject {

    public DefaultBoardDataAccessObject () {
    }

    @Override
    public String[][] createBoardMultiplierGrid(String csvPath) throws IOException {
        String nextLine;
        String [][] returnArray = new String[0][];
        boolean isEmpty = true;
        int currentIndex = 0;

        BufferedReader br = new BufferedReader(new FileReader(csvPath));
        while((nextLine = br.readLine()) != null) {
            String [] values = nextLine.split(",");
            if (isEmpty) {
                returnArray = new String [values.length][values.length];
                isEmpty = false;
            }
            System.arraycopy(values, 0, returnArray[currentIndex], 0, values.length);
            currentIndex++;
        }
        return returnArray;
    }
}
