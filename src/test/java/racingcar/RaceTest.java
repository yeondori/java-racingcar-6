package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    @DisplayName("레이스 생성 및 실행 테스트")
    void createAndRunRaceTest() {
        // given
        String[] carNames = {"dori", "pobi", "jun"};
        Race race = Race.of(carNames);

        // when
        Map<String, Integer> finalPositions = race.run();

        // then
        assertThat(finalPositions).hasSize(3);

        finalPositions.forEach((carName, finalPosition) ->
                assertThat(finalPosition).isBetween(0, 1)
        );
    }
}