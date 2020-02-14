package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 1, 3, 2, 4, 0};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int idx = Arrays.binarySearch(arr, 3);
		System.out.println("Array : " + idx);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(0);
		Collections.sort(list);
		System.out.println(list.toString());
		idx = Collections.binarySearch(list, 3);
		System.out.println("List : " + idx);
		
		Node[] arrClass = new Node[6];
		arrClass[0] = new Node(5);
		arrClass[1] = new Node(1);
		arrClass[2] = new Node(3);
		arrClass[3] = new Node(2);
		arrClass[4] = new Node(4);
		arrClass[5] = new Node(0);
		Arrays.sort(arrClass);
		System.out.println(Arrays.toString(arrClass));
		idx = Arrays.binarySearch(arrClass, new Node(5));
		System.out.println("ClassArray : " + idx);
		
		List<Node> listClass = Arrays.asList(arrClass);
		System.out.println(listClass.toString());
		idx = Collections.binarySearch(listClass, new Node(4));
		System.out.println("ClassList : " + idx);
	}
	
	static class Node implements Comparable<Node>{
		int x;
		
		Node(int _x){
			this.x = _x;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return (this.x < o.x) ? -1 : (this.x == o.x) ? 0 : 1; 
		}
		
		public String toString() {
			return x + ",";
		}
	}

}
