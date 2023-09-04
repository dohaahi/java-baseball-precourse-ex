package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();

        GameController gameController = new GameController( outputView, gameService);
        gameController.start();
    }
}
