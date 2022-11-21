package default_reference_values;

import launch_new_game_use_case.LaunchGameDataAccessObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DefaultBoardDataAccessObject implements LaunchGameDataAccessObject {
    private String csvPath;

    public DefaultBoardDataAccessObject (String csvPath) {
        this.csvPath = csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public String[][] createBoardMultiplierGrid() throws IOException {
        String nextLine;
        String [][] returnArray = new String[0][];
        boolean isEmpty = true;
        int currentIndex = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
        while((nextLine = br.readLine()) != null) {
            String [] values = nextLine.split(",");
            if (isEmpty) {
                returnArray = new String [values.length][values.length];
                isEmpty = false;
            }
            System.arraycopy(values, 0, returnArray[currentIndex], 0, values.length);
        }
        return returnArray;
    }
}
