package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;

    private Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static Car of(String name) {
        validateName(name);
        return new Car(name, 0);
    }

    private static void validateName(String name) {
        if (name.length()>5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이내여야 합니다.");
        }
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
