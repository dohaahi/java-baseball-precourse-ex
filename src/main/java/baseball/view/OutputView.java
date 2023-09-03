package baseball.view;

import java.util.Map;

public class OutputView {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 :";
    private static final String INPUT_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public static void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER);
    }

    public static void printInputRetryMessage() {
        System.out.print(INPUT_RETRY);
    }

    public void printGameResult(Map<String, String> result) {
        String strike = result.get("strike");
        String ball = result.get("ball");
        String nothing = result.get("낫싱");

        if ("3".equals(strike)) {
            System.out.println("3스트라이크");
            return;
        }

        if ("1".equals(nothing)) {
            System.out.println("낫싱");
            return;
        }

        if (!"0".equals(ball) && !"0".equals(strike)) {
            System.out.printf("%s볼 %s스트라이크", ball, strike);
            return;
        }

        if (!"0".equals(ball)) {
            System.out.printf("%s볼", ball);
        }

        if (!"0".equals(strike)) {
            System.out.printf("%s스트라이크", strike);
        }
    }

    public void endGame() {
        System.out.print(END_GAME);
    }
}
