package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    public static List<Car> getWinners(List<Car> racingCars) {
        int maxPosition = getMaxPosition(racingCars);
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> racingCars) {
        return racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}