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
  - ...
- **DefaultBoard**
  - ...
- **Dictionary**
  - ...

### Application Business Rules (Use Cases)
- Take Turn
  - ...
- Launch New Game
  - ...
- Place Word Refill
  - ...
- Exchange Letters
  - ...
- Reload Game
  - ...
- Save Game
  - ...
- Game End Bag Empty:
  - This use case is supposed to be implmeneted within the Take Turn code, however it has been replaced with a more elegant fix which is a one line fix in Take Turn use case. But the original intention of this use case is to take in a a reference of the Bag created in GameState, and it would check whether it is empty and will indicate whether the game ends or not. It indicates this by implementing an interface GameEndEmptyBagInput Boundary for a successful case which is return to in the Take Turn use case using the GameEndEmptyBagOutputBoundary. And then within Take Turn, if it is true, it would find which Player has a higher score and end game with that Player as the winner.

### Interface Adapters
- Presenter: This is the go between layer between the use cases (business application layer) and the ViewModel (Franework and Drivers). It is set up in such a way that through dependency inversion, the use cases update the attributes in presenter through the Output Boundary interfaces and in turn, the Presenter updates the ViewModel through dependency inversion. The ViewModel then calls the update methods in ViewFinal to update the attributes and thus it updates the GUI. 
  - 
- Controller:
  - 

### Frameworks and Drivers
- ViewFinal:
  - This is the final framework which is the most outer layer. It interacts directly with the ViewModel. This highlights the principle of "low coupling, high cohesion". The ViewFinal class is responsible for creating the entire GUI. It sets up the frame and the board and all the buttons. And whenever a user action is called, it calls the proper methods through controller which in turn calls the right use cases that modifiy the core enteties.
- ViewModel:

# Feedback to address
## Functionality
  - Start working on the Main to make something happen
  - Add the turn process
## Pull Requests
  - More detail in describing what the pull requests do
  - More significant pull requests from those who haven’t 
## Code Organization
  - Organize into better packages (unanimous convention)
## Code Style
  - Add significant JavaDoc documentation
## GitHub Features
  - Keep up to date on GitHub Issues (create when working on a new feature)
  - Add current tasks to the projects feature
## Design Patterns
  - Utilized Factory, Facade, Dependency Injection, ...
## Clean Architecture
  - Generally well done, connect view and data persistence with use case layer to complete the flow of control 
## SOLID
  - Also well done, continue following SOLID

## How to run the code:
- Run the Main() file.
