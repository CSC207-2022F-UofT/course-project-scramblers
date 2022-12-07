package storage;

import core_entities.game_parts.SerializableGameState;
import use_cases.reload_game_use_case.ReloadGameDsGateway;
import use_cases.reload_game_use_case.ReloadGameDsResponseModel;
import use_cases.save_game_use_case.SaveGameDsGateway;

import java.io.*;

/**
 * Storage Manager is the data store gateway which saves and reloads versions of the game to achieve
 * persistence
 */
public class StorageManager implements SaveGameDsGateway, ReloadGameDsGateway {


    /**
     * Attempts to save the serializable version of GameState into a file for persistence
     * @param serializableGameState SerializableGameState
     * @return boolean
     */
    @Override
    public boolean saveSerializable(SerializableGameState serializableGameState) {
        try {
            FileOutputStream f = new FileOutputStream("src/main/java/storage/state.txt", false);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(serializableGameState);

            o.close();

            return true;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            return false;
        }

    }

    /**
     * Checks the state.txt file which should have a serializable version of GameState and returns the
     * relevant information in a response model
     * @return ReloadGameDsResponseModel
     */
    @Override
    public ReloadGameDsResponseModel reload() {
        try {
            FileInputStream f = new FileInputStream("src/main/java/storage/state.txt");
            ObjectInputStream o = new ObjectInputStream(f);
            SerializableGameState s = (SerializableGameState) o.readObject();
            o.close();
            return new ReloadGameDsResponseModel(s.getP1(), s.getP2(), s.getBoard());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
