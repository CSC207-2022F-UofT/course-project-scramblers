# TEAM SCRAMBLERS 

## Test Coverage

## Functionality

## Explanation of Design Patterns

### Dependency Injection
- Heavily used in various entities such as LetterRack and GameState
- Main reason for use is to:
  - ensure the same objects are being referenced from different entities
  - If dependent on an interface, then ensure the interfaces can always be used regardless of impletmentation
- Easily extended and sometimes required depending on entity
  - Presenters and controllers and often rely on dependency injection
  - Entities requiring dependency injection are case-by-case

### Factory 
- Used in BoardFactory, explained in the BoardFactory Interface
- Complies with the Open/Closed Principle of SOLID
- This design pattern could easily be extended to the other entities (i.e. Player, Bag, etc.)

### Facade
- Used in PlaceWordRefillInteractor, further explained in detail in its JavaDoc
- Complies with Open/Closed and Single Responsibility principle's of SOLID
- 
## Overall Structure - What is in each layer and how the flow of control works

## How to run the code:
