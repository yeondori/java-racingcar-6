package racingcar;

public class Car {

    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }

        return new Car(name, 0);
    }

    public void go(int input) {
        if (input >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
