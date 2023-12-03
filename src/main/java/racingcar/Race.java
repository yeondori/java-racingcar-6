package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, Integer> run() {
        racingCars.forEach(
                car -> car.move(Randoms.pickNumberInRange(0, 9)));

        return racingCars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}