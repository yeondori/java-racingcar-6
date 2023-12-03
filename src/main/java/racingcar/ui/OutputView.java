package racingcar.ui;

import racingcar.Car;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printResult(Map<String, Integer> runResult) {
        runResult.forEach((name, position) -> System.out.println(name + " : " + "-".repeat(position)));
        System.out.println("");
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
