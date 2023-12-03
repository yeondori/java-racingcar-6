package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String[] cars = inputView.RequestCars();
        int roundNumber = inputView.RequestNumber();

        Race race = Race.of(cars);
        executeRacing(roundNumber, race);
    }

    private static void executeRacing(int roundNumber, Race race) {
        System.out.println("실행 결과");

        for (int round = 0; round < roundNumber; round++) {
            Map<String, Integer> roundResult = race.run();
            outputView.printResult(roundResult);
        }

        List<Car> winners = Result.getWinners(race.getRacingCars());
        outputView.printWinners(winners);
    }
}