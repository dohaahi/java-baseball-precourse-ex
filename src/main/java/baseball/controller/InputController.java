package baseball.controller;

import baseball.view.InputView;

public class InputController {

    private final static String NUMBER_LENGTH_WRONG_ERROR = "3자리 숫자를 입력해주새요.";
    private final static String NUMBER_RANGE_WRONG_ERROR = "1~9 사이에 숫자를 입력해주새요.";

    private final InputView inputView = new InputView();

    // 사용자가 입력한 숫자 검증
    public String readNumber() {
        String userNumber = inputView.inputNumber();

        if (userNumber.length() != 3) {
            throw new IllegalArgumentException(NUMBER_LENGTH_WRONG_ERROR);
        }

        char[] userNumberCharArray = userNumber.toCharArray();

        for (char n : userNumberCharArray) {
            if (n < 49 || n > 57) {
                throw new IllegalArgumentException(NUMBER_RANGE_WRONG_ERROR);
            }
        }

        return userNumber;
    }

    public String readRestart() {
        String inputRestart = inputView.inputRestart();

        if (!"1".equals(inputRestart) || !"2".equals(inputRestart) ) {
                throw new IllegalArgumentException(NUMBER_RANGE_WRONG_ERROR);
            }

        return inputRestart;
    }
}

/*
    inputController는 InputView를 멤버변수로 갖음
    Gamecontroller는 InputController에 접근 가능 + InputView에 접근 불가능

 */