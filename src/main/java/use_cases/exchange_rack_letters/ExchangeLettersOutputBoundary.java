package use_cases.exchange_rack_letters;

public interface ExchangeLettersOutputBoundary {
    /**
     * call for the viewModel class to be updated to reflect changes.
     */
    void updateViewModelAfterExchange();
}
