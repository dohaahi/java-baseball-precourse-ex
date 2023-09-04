package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class GameController {

    private final OutputView outputView;
    private final GameService gameService;
    private final InputController inputController = new InputController();

    public GameController(OutputView outputView, GameService gameService) {
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void start() {
        // TODO: 검증 후 오류 발생 시 게임 재실행되도록 구현
        String userNumber = inputController.readNumber();

        Map<String, String> result = play(userNumber);

        outputView.printGameResult(result);
        outputView.endGame();

        // 게임이 끝난 뒤 재시작여부 입력
        String restartAnswer = inputController.readRestart();
        restart(restartAnswer);
    }

    // 3스트라이크가 될 때 까지 게임 실행
    private Map<String, String> play(String userNumber) {
        Map<String, String> result = gameService.play(userNumber);
        String strike = result.get("strike");

        while (!"3".equals(strike)) {
            outputView.printGameResult(result);

            // 유저가 번호 입력
            userNumber = inputController.readNumber();
            result = gameService.play(userNumber);

            strike = result.get("strike");
        }
        return result;
    }


    private void restart(String restartAnswer) {
        boolean isRestart = gameService.restart(restartAnswer);

        if (isRestart) {
            start();
        }
    }
}
