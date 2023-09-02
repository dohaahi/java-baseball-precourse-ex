package baseball.view;

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

    // TODO: 게임 결과 출력
    // 스트라이크, 볼, 낫싱

    public void endGame() {
        System.out.print(END_GAME);
    }
}
