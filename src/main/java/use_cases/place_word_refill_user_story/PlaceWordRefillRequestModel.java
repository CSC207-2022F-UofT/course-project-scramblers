package use_cases.place_word_refill_user_story;

public class PlaceWordRefillRequestModel {
    final PlaceWordRefillController placeWordRefillController;
    final PlaceWordRefillPresenter placeWordRefillPresenter;

    public PlaceWordRefillRequestModel(PlaceWordRefillController placeWordRefillController,
                                       PlaceWordRefillPresenter placeWordRefillPresenter) {
        this.placeWordRefillController = placeWordRefillController;
        this.placeWordRefillPresenter = placeWordRefillPresenter;
    }

    public PlaceWordRefillController getPlaceWordRefillController() {
        return placeWordRefillController;
    }

    public PlaceWordRefillPresenter getPlaceWordRefillPresenter() {
        return placeWordRefillPresenter;
    }
}
