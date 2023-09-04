package baseball.controller;

import baseball.service.GameService;
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
        try {
            String userNumber = inputController.readNumber();
            Map<String, String> result = play(userNumber);

            outputView.printGameResult(result);
            outputView.endGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        // 게임이 끝난 뒤 재시작여부 입력
        try {
            String restartAnswer = inputController.readRestart();
            restart(restartAnswer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

        if ("1".equals(restartAnswer)) {
            start();
        }
    }
}
