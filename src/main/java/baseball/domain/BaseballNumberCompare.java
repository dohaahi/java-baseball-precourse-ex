package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballNumberCompare {

    private int ball = 0;
    private int strike = 0;
    private int nothing = 0;

    private final Map<String, String> result = new HashMap<>();

    // 두 수를 비교하는 로직
    public void compare(List<String> userNumber, List<String> randomNumber) {

        // 3스트라이크인 경우
        if (userNumber.equals(randomNumber)) {
            strike = 3;
            return;
        }

        for (int i = 0; i < userNumber.size(); i++) {
            for (int j = 0; j < randomNumber.size(); j++) {
                if (userNumber.get(i).equals(randomNumber.get(j))) {
                    if (i == j) {
                        strike++;
                        continue;
                    }
                    ball++;
                }
            }
        }

        if (strike == 0 && ball == 0) {
            nothing++;
        }

    }

    private void setMap() {
        result.clear();

        result.put("strike", Integer.toString(strike));
        result.put("ball", Integer.toString(ball));
        result.put("낫싱", Integer.toString(nothing));

        resetField();
    }

    public Map<String, String> getResult() {
        setMap();
        return result;
    }

    private void resetField() {
        ball = 0;
        strike = 0;
        nothing = 0;
    }
}
