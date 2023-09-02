package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    // 사용자에게 3자리 숫자 입력 받음
    public String inputNumber() {
        OutputView.printInputNumberMessage();
        return readLine();
    }

    // 게임 종료 후 재시작 여부 입력 받음
    public String inputRetry() {
        OutputView.printInputRetryMessage();
        return readLine();
    }
}
