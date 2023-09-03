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
                    continue;
                }
            }
        }

        nothing++;
    }

    private void setMap() {
        result.put("strike", Integer.toString(strike));
        result.put("ball", Integer.toString(ball));
        result.put("낫싱", Integer.toString(nothing));
    }

    public Map<String, String> getResult() {
        return result;
    }
}
