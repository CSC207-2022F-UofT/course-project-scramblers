package storage;

import CoreEntities.Player.Player;
import core_entities.game_parts.SerializableGameState;
import use_cases.reload_game_use_case.ReloadGameDsGateway;
import use_cases.reload_game_use_case.ReloadGameDsResponseModel;
import use_cases.save_game_use_case.SaveGameDsGateway;

import java.io.*;

public class StorageManager implements SaveGameDsGateway, ReloadGameDsGateway {


    @Override
    public boolean saveSerializable(SerializableGameState serializableGameState) {
        try {
            FileOutputStream f = new FileOutputStream(new File("state.txt"));
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

    @Override
    public ReloadGameDsResponseModel reload() {
        try {
            FileInputStream f = new FileInputStream(new File("state.txt"));
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
