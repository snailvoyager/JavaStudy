import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>[] arrList = new ArrayList[10];
		for(int i=0; i<10; i++)
			arrList[i] = new ArrayList<>();
		
		arrList[0].add(0);
		arrList[0].add(1);
		arrList[1].add(1);
		arrList[2].add(2);
		
		for(int i=0; i<3; i++) 
			System.out.println(arrList[i].toString());
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<10; i++)
			adjList.add(new ArrayList<Integer>());
		
		adjList.get(0).add(0);
		adjList.get(0).add(1);
		adjList.get(1).add(1);
		adjList.get(2).add(2);
		
		for(ArrayList<Integer> i : adjList)
			System.out.println(i.toString());
	}

}
