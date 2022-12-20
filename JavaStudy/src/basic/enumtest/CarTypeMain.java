package basic.enumtest;

import java.util.Arrays;
import java.util.EnumSet;

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
        System.out.println();

        EnumSet<CarType> set = EnumSet.allOf(CarType.class);    //모든 상수 포함하여 set 생성
        set.forEach(System.out::println);
        EnumSet<CarType> set2 = EnumSet.noneOf(CarType.class);  //빈 set 생성
        set2.add(CarType.EV);
        set2.add(CarType.SEDAN);
        set2.forEach(System.out::println);
        EnumSet<CarType> set3 = EnumSet.complementOf(set2);     //원하는 상수 제외
        set3.forEach(System.out::println);
        System.out.println(set3.contains(CarType.VAN));
    }
}
