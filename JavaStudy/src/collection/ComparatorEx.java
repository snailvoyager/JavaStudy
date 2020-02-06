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
		System.out.println("�迭 ���� : " + Arrays.toString(arr));
		
		ArrayList<Integer> list = new ArrayList<Integer>();		//IntegerŬ������ Comparable �������̽��� ������ compareTo()�� ���� ����
		list.add(5);
		list.add(3);
		list.add(8);
		list.add(2);
		list.add(9);
		Collections.sort(list);
		System.out.println("����Ʈ(Collections) �������� ���� : " + list.toString());
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(3);
		list2.add(8);
		list2.add(2);
		list2.add(9);
		
		Comparator<Integer> cp = new Comparator<Integer>() {	//Comparator �͸� Ŭ���� �̿�
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (o1 < o2) ? 1 : -1;			//������������ ����
			}
		};
		
		Collections.sort(list2, cp);
		System.out.println("����Ʈ(Comparator) �������� ���� : " + list2.toString());
	}

}
