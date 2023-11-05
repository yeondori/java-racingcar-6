package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        List<Car> cars = requestRacers();
        int num = requestNum();

        System.out.println("\n실행 결과");

        for (int i = 0; i < num; i++) {
            race(cars);
        }
        judge(cars);
    }

    public static List<Car> requestRacers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");

        return Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toList());
    }

    public static int requestNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();

        if (!input.matches("^[1-9]\\d*$")) throw new IllegalArgumentException();

        return Integer.parseInt(input);
    }

    public static void race(List<Car> cars) {
        for (Car car : cars) {
            car.go(Randoms.pickNumberInRange(0, 9));
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("");
    }

    public static void judge(List<Car> cars) {
        Judgement judgement = new Judgement(cars);
        String winners = String.join(",", judgement.findWinners());
        System.out.println("최종 우승자 : " + winners);
    }
}