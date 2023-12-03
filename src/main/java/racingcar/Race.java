package racingcar;

import java.util.Arrays;
import java.util.List;

public class Race {
    private final List<Car> racingCars;

    private Race(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public static Race of(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::of)
                .toList();
        return new Race(cars);
    }

    public void race() {
        racingCars.forEach(Car::move);
    }
}
