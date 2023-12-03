package racingcar.ui;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String[] RequestCars() {
        String input = readLine();

        validateCarsInput(input);
        return input.split(",");
    }

    public int RequestNumber() {
        String input = readLine();

        validateNumberInput(input);
        return Integer.parseInt(input);
    }

    private void validateNumberInput(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 숫자만 입력 가능합니다.");
        }
    }

    private void validateCarsInput(String input) {
        validateInput(input);
        validateContainComma(input);
        validateDuplicate(input);
    }

    private void validateInput(String input) {
        if(!input.matches("^[,a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 참가자 이름은 문자나 숫자로만 구성되어야 합니다.");
        }
    }

    private void validateContainComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 경기 참가자는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicate(String input) {
        long uniqueSize = Arrays.stream(input.split(","))
                .distinct()
                .count();

        if (input.split(",").length != uniqueSize) {
            throw new IllegalArgumentException("[ERROR] 참가자 이름은 중복 입력이 불가합니다.");
        }
    }
}