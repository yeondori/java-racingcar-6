package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}