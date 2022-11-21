package place_word_refill_user_story;

public interface PlaceWordRefillOutputBoundary {
    void prepareSuccessView(PlaceWordRefillResponseModel placeWordRefillResponseModel);

    void prepareFailView(String error);
}
