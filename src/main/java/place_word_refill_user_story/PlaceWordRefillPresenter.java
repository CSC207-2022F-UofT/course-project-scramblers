package place_word_refill_user_story;

public interface PlaceWordRefillPresenter {
    PlaceWordRefillResponseModel prepareSuccessView(PlaceWordRefillResponseModel placeWordRefillResponseModel);

    PlaceWordRefillResponseModel prepareFailView(String error);
}
