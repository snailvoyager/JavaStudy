package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 3, 8, 2, 9};
		Arrays.sort(arr);
		System.out.println("배열 정렬 : " + Arrays.toString(arr));
		
		ArrayList<Integer> list = new ArrayList<Integer>();		//Integer클래스의 Comparable 인터페이스를 구현한 compareTo()에 따라 정렬
		list.add(5);
		list.add(3);
		list.add(8);
		list.add(2);
		list.add(9);
		Collections.sort(list);
		System.out.println("리스트(Collections) 오름차순 정렬 : " + list.toString());
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(3);
		list2.add(8);
		list2.add(2);
		list2.add(9);
		
		Comparator<Integer> cp = new Comparator<Integer>() {	//Comparator 익명 클래스 이용
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (o1 < o2) ? 1 : -1;			//내림차순으로 변경
			}
		};
		
		Collections.sort(list2, cp);
		System.out.println("리스트(Comparator) 내림차순 정렬 : " + list2.toString());
	}

}
