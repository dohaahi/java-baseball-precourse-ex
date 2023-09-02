package baseball.util;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {

    private final Set<Integer> randomNumber = new HashSet<>();

    public Set<Integer> makeRandomNumber() {

        // 중복 없이 랜덤하게 숫자 3개를 뽑음
        while (randomNumber.size() < 3) {
            randomNumber.add(pickNumberInRange(1, 9));
        }

        return randomNumber;
    }
}
