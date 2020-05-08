package collection;

import java.util.Arrays;
import java.util.Comparator;

public class StringSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"cc", "aa", "bb", "dd"};
		
		Arrays.sort(arr);		//오름차순
		System.out.println(Arrays.toString(arr));
		
		Comparator<String> cp = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);		//내림차순
			}
		};
		Arrays.sort(arr, cp);
		System.out.println(Arrays.toString(arr));
	}

}
