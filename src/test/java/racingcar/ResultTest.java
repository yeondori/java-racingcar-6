package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @Test
    @DisplayName("이동하지 않은 경우 우승자는 전체 참가자이다.")
    void getWinnersIfAllStop() throws Exception {
        //given
        List<Car> racingCars = Arrays.asList(Car.of("dori"), Car.of("pobi"), Car.of("jun"));
        //when
        List<Car> winners = Result.getWinners(racingCars);
        //then
        assertThat(winners).hasSize(3);
    }

}