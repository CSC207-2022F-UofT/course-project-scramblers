package core_entities.game_parts;

public interface BoardFactory {
    /**
     * Use of the Factory Design Pattern to create new instances of Boards and leave the door open for custom Boards
     * Uses csv files to import initial states of the board, allowing for inputs of custom declarations
     * I decided on using this design pattern because it does not rely on any direct dependencies (i.e. new Board()),
     * and it allows for extension while being closed for modification (Open Closed Principle)
     * @param multipliers - The string representation of the multipliers of the Grid of the Board
     * @return a new instance of Board based on the type of Board in the BoardFactory
     */
    Board create(String [][] multipliers);
}
