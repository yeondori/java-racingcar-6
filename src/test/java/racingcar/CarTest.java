package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("이름이 5자 이상인 경우 예외를 던진다.")
    void validateNameException() {
        // given
        String invalidName = "invalidName";

        // when & then
        assertThatThrownBy(() -> Car.of(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이내여야 합니다.");
    }

    @DisplayName("4 미만인 경우에는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopIfLessThan4(int number) {

        Car dori = Car.of("dori");
        dori.move(number);
        assertThat(dori.getPosition()).isZero();
    }

    @DisplayName("4 이상인 경우에는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void stopIfMoreThan4(int number) {

        Car dori = Car.of("dori");
        dori.move(number);
        assertThat(dori.getPosition()).isEqualTo(1);
    }
}