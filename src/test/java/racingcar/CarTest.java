package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("이름을 가진 Car 객체를 생성한다.")

    void createCar() throws Exception {
        //given
        String carName = "toby";
        //when
        Car toby = Car.of(carName);
        //then
        assertThat(toby.getName()).isEqualTo(carName);
    }

    @DisplayName("4 미만인 경우에는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopIfLessThan4(int number) {

        Car dori = Car.of("dori");
        dori.move(number);
        assertThat(dori.getPosition()).isZero();
    }
}