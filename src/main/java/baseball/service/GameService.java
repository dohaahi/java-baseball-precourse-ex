package baseball.service;


import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberCompare;

import java.util.List;
import java.util.Map;

public final class GameService {

    private final BaseballNumber baseballNumber = new BaseballNumber();
    private final BaseballNumberCompare baseballNumberCompare = new BaseballNumberCompare();


    // 기능
    // BaseballNumber에 저장된 두 수를 비교하여 결과 리턴
    public Map<String,String> play(String userBaseballNumber) {
        List<String> userNumber = baseballNumber.inverterUserNumber(userBaseballNumber);
        List<String> randomNumber = baseballNumber.inverterRandomNumber();

        baseballNumberCompare.compare(userNumber, randomNumber);
        return baseballNumberCompare.getResult();
    }

    public boolean restart(String restartAnswer) {
        if ("1".equals(restartAnswer)) {
            return true;
        }

        if ("2".equals(restartAnswer)) {
            return false;
        }

        // TODO: 입력 검증 controller로 이동
        throw new IllegalArgumentException("1, 2 중에 하나를 입력해주세요.");
    }

}