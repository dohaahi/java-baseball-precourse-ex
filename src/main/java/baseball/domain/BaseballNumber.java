package baseball.domain;

import baseball.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumber {

    // user가 입력한 번호와
    // random으로 생성된 숫자를 인자로 갖음
    // 입력받은 숫자 list로 변환
    // 랜덤 숫자 list로 변환

    private List<String> userNumber;
    private List<String> randomNumber;

    public List<String> inverterUserNumber(String userBaseballNumber) {
        userNumber = Arrays.stream(userBaseballNumber.split(""))
                .collect(Collectors.toList());

        return userNumber;
    }

    public List<String> inverterRandomNumber() {

        // randomNumber가 없을 때만 makeRandomNumber 실행
        if (randomNumber==null) {
            Set<Integer> madeRandomNumber = RandomNumberGenerator.makeRandomNumber();

            randomNumber = madeRandomNumber.stream()
                    .map(i -> Integer.toString(i))
                    .collect(Collectors.toList());
        }

        return randomNumber;
    }

}
