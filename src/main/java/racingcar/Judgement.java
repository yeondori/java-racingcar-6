package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    private final List<Car> cars;

    public Judgement(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        if (cars.isEmpty()) {
            return 0;
        }

        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
