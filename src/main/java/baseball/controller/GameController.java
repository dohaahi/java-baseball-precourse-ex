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
        validateInputNumber(userNumber);

        Map<String, String> result = play(userNumber);

        outputView.printGameResult(result);
        outputView.endGame();

        // 게임이 끝난 뒤 재시작여부 입력
        String restartAnswer = inputView.inputRestart();
        restart(restartAnswer);
    }

    // 3스트라이크가 될 때 까지 게임 실행
    private Map<String, String> play(String userNumber) {
        Map<String, String> result = gameService.play(userNumber);
        String strike = result.get("strike");

        while (!"3".equals(strike)) {
            outputView.printGameResult(result);

            // 유저가 번호 입력
            userNumber = inputView.inputNumber();
            validateInputNumber(userNumber);
            result = gameService.play(userNumber);

            strike = result.get("strike");
        }
        return result;
    }

    // TODO: 검증 후 오류 발생 시 게임 재실행되도록 구현
    private void validateInputNumber(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주새요.");
        }

        char[] userNumberCharArray = userNumber.toCharArray();

        for (char n : userNumberCharArray) {
            if (n < 49 || n > 57) {
                throw new IllegalArgumentException("1~9 사이에 숫자를 입력해주새요.");
            }
        }


    }

    private void restart(String restartAnswer) {
        boolean isRestart = gameService.restart(restartAnswer);

        if (isRestart) {
            start();
        }
    }
}
