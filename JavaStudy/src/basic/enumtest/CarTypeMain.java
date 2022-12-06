package basic.enumtest;

import java.util.Arrays;

public class CarTypeMain {
    public static void main(String[] args) {
        System.out.println(CarType.EV);
        System.out.println(CarType.EV.getCapacity());   //getter
        System.out.println(CarType.EV.getSeat());       //getter

        System.out.println(Arrays.toString(CarType.values()));      //enum 모든 상수 값 배열 리턴
        System.out.println(CarType.valueOf("VAN"));     //parameter와 일치하는 상수 리턴
        System.out.println(CarType.EV.ordinal());   //상수 값의 index

        System.out.println(CarType.getCarByCC("2000cc"));   //속성이 일치하는 상수 리스트 리턴
        System.out.println(CarType.getCarBySeat(5));

    }
}
