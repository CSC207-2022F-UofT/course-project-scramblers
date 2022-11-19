package place_word_refill_user_story;

public class PlaceWordRefillResponseModel {
    boolean success;

    public PlaceWordRefillResponseModel(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
