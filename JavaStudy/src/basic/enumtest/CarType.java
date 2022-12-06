package basic.enumtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CarType {

    SEDAN("2000cc", 5),
    SUV("3000cc", 6),
    EV("1800cc", 5),
    VAN("4000cc", 9);

    private final String capacity;
    private final int seat;
    CarType(String capacity, int seat) {
        this.capacity = capacity;
        this.seat = seat;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getSeat() {
        return seat;
    }

    //capacity가 일치하는 속성 리턴
    public static List<CarType> getCarByCC(String capacity) {
        return Arrays.stream(values())
                .filter(x -> x.capacity.equals(capacity))
                .collect(Collectors.toList());
    }

    public static List<CarType> getCarBySeat(int seat) {
        return Arrays.stream(values())
                .filter(x -> x.seat == seat)
                .collect(Collectors.toList());
    }
}
