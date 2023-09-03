package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void start() {

        String userNumber = inputView.inputNumber();

        Map<String, String> result = play(userNumber);

        outputView.printGameResult(result);
        outputView.endGame();
    }

    // 3스트라이크가 될 때 까지 게임 실행
    private Map<String, String> play(String userNumber) {
        Map<String, String> result = gameService.play(userNumber);
        String strike = result.get("strike");

        while (!"3".equals(strike)) {
            outputView.printGameResult(result);

            // 유저가 번호 입력
            userNumber = inputView.inputNumber();
            result = gameService.play(userNumber);

            strike = result.get("strike");
        }
        return result;
    }
}
