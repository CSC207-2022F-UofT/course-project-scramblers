# TEAM SCRAMBLERS 

## Test Coverage
<img width="476" alt="Screen Shot 2022-12-07 at 3 42 58 PM" src="https://user-images.githubusercontent.com/74324750/206292676-a3779840-ec4a-4246-bb51-66ecfafe9609.png">

## Functionality
- ...

## Explanation of Design Patterns

### Dependency Injection
- Heavily used in various entities such as:
  - LetterRack
  - GameState
  - Various Use Case Interactors
  - Controller
  - DictionaryFunctions
- Main reason for use is to:
  - ensure the same objects are being referenced from different entities
    - Using aliasing to simulate real such tiles out of a bag that everyone shares
  - If dependent on an interface, then ensure the interfaces can always be used regardless of impletmentation
  - Easily extended and sometimes required depending on entity
    - Follows Open-Close principle
    - Off loads work mostly to main which is responsible for instantiation anyways (follows single responsibility principle)

### Factory 
- Used in BoardFactory, explained in the BoardFactory Interface
- Complies with the Open/Closed Principle of SOLID
- This design pattern could easily be extended to the other entities (i.e. Player, Bag, etc.)

### Facade
- Used in PlaceWordRefillInteractor, further explained in detail in its JavaDoc
- Complies with Open/Closed and Single Responsibility principle's of SOLID
- This design pattern was used in order to comply with the Single Responsibility Rule, which is done by delegating certain tasks to other classes so that the Interactor is only responsible for its tasks.
### Singleton
- Used in Dictionary as it is only created once it fulfils single responsibility.
- Uses an interface to be accessed by use cases to decouple and eliminate dependancies. 

## Overall Structure - What is in each layer and how the flow of control works

### Enterprise Business Rules (Entities)
- **Bag**
  - Represents the bag of letters of the game. Contains an ArrayList of Tile objects which can be taken out and added as needed.
- **Tile**
  - Represents a letter that can be used in the game. Contains a char representation of the letter, and the value of that letter.
- **Square**
  - Represents a spot on the grid of the board. Contains the Tile it is holding (or null) and the multiplier corresponding to this spot.
- **LetterRack**
  - Represents the letters a player has. Contains a reference to the Bag, a list of the Tile objects, and an integer representing its length.
- **Coordinate**
  - Represents a spot on the location on the grid of the board. Contains integers for the x-coordinate and y-coordinate.
- **GameState**
  - Contains static attributes to act as a global access point for the use cases to interact with the board data
- **DefaultBoard**
  - The representation of the current board state, as a default square, and has functionality to extract the letter grid and the multiplier grid
- **Dictionary**
  - This represents all the valid 176,000 words sthat can be used in the game of Scrabble. It contains a hashmap of unique keys represented as sets of    characters, and arraylists of strings as values. 

### Application Business Rules (Use Cases)
- Take Turn
  - Determine which use case to call either Place Word Refill or Exchange Letter.
  - If the word is suceessfully being placed or exchanged, check if the game need to end.
  - If the game need to end, call the method in outputboundary to update view.
  - If the game does not need to end, change turn and call the Save Game use case.
- Launch New Game
  - Launches the Game by creating new instances of the Entities required, then calls the method in the OutputBoundary to update the current Player's letter rack and the Board grid
  - Involves InputBoundary, RequestModel, OutputBoundary, ResponseModel, CreateDictionaryDataAccessObject (Dependency Inversion) 
  - References GameState.set() methods to set the current attributes after their creation
  - Accesses a csv file for the default board multipliers
- Place Word Refill
  - Involves InputBoundary, RequestModel, OutputBoundary, ResponseModel, and classes for delegated tasks (Facade)
  - References GameState getters to obtain players and the board
  - Establishes classes for delegated tasks
  - Currently does not check the dictionary, but should in the future
- Exchange Letters
  - ...
- Reload Game
  - ...
- Save Game
  - ...
- Game End Bag Empty:
  - This use case is supposed to be implmeneted within the Take Turn code, however it has been replaced with a more elegant fix which is a one line fix in Take Turn use case. But the original intention of this use case is to take in a a reference of the Bag created in GameState, and it would check whether it is empty and will indicate whether the game ends or not. It indicates this by implementing an interface GameEndEmptyBagInput Boundary for a successful case which is return to in the Take Turn use case using the GameEndEmptyBagOutputBoundary. And then within Take Turn, if it is true, it would find which Player has a higher score and end game with that Player as the winner.
- Choose word:
  - This use case was meant to be implemented in take turn when a player wants to make a move on the board. Due to changes in the implementation of the game, this use case has been replaced with other code in take turn. Originally, this use case was meant to determine if a chosen word by a player was in the dictionary or not in order to allow them to place a valid word on the board, by calling the Dictionary.getCharacterSetDictionary method.

### Interface Adapters
- Presenter: This is the go between layer between the use cases (business application layer) and the ViewModel (Franework and Drivers). It is set up in such a way that through dependency inversion, the use cases update the attributes in presenter through the Output Boundary interfaces and in turn, the Presenter updates the ViewModel through dependency inversion. The ViewModel then calls the update methods in ViewFinal to update the attributes and thus it updates the GUI. 
  - ...
- Controller:
  - ...
- DictionaryGatewayReader decouples the accessing of data from the construction of the dictionary. This allows for easily swapping out different languages or alphabets in future use while allowing the Dictionary to form regardless. 
### Frameworks and Drivers
- ViewFinal:
  - This is the final framework which is the most outer layer. It interacts directly with the ViewModel. This highlights the principle of "low coupling, high cohesion". The ViewFinal class is responsible for creating the entire GUI. It sets up the frame and the board and all the buttons. And whenever a user action is called, it calls the proper methods through controller which in turn calls the right use cases that modifiy the core enteties.
- ViewModel:
- DefaultBoardDataAccessObject - Concrete implementation of CreateDictionaryDataAccessObject that accesses board-data.csv
- board-data.csv - Contains a csv representation of the default board mutlipliers

# Addressed Feedback
## Functionality
  - Added the main file, with most of the game functional 
  - Added the turn process, score accumulation, exchanging letters, launching a new game, displaying the board, and quitting/reloading/saving the game
## Pull Requests
  - Future pull requests were reviewed and submitted with more detail
## Code Organization
  - Organized all files into proper packages
## Code Style
  - Increased documentation to most files added, explaining their functionality
## GitHub Features
  - GitHub Issues were created whenever there was something to do
  - New branches were created based on the created issues
## Design Patterns
  - Utilized Factory, Facade and Dependency Inversion
## Clean Architecture
  - Finished the clean architecture model by adding View, ViewModel and Presenter/Controller
## SOLID
  - Adhered to SOLID principles, including Depedency Inversion for passing in ViewModel

## How to run the code:
- Open the Main.java file, and run the program. The application should open in a separate tab, and the game can be played
