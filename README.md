# TEAM SCRAMBLERS 

## Test Coverage
<img width="476" alt="Screen Shot 2022-12-07 at 3 42 58 PM" src="https://user-images.githubusercontent.com/74324750/206292676-a3779840-ec4a-4246-bb51-66ecfafe9609.png">

## Functionality

## Explanation of Design Patterns

### Dependency Injection
- Heavily used in various entities such as:
  - LetterRack
  - GameState
  - Various Use Case Interactors
  - Controller
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
  - ...

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
  - ...
- Exchange Letters
  - ...
- Reload Game
  - ...
- Save Game
  - ...

### Interface Adapters
- ...

### Frameworks and Drivers
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
