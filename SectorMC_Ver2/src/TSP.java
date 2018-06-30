import java.util.ArrayList;

public class TSP {
	
	public ArrayList<Cluster> myList = null;
	public double result = 0;
	// 처음에는 거리, 그러나 나중에 기존알고리즘처럼 진행하려면 새로운 Parameter를 추가하여야 한다.
	
	public int N = 0;
	
	
	TSP()
	{
		
	}
	
	TSP(ArrayList<Cluster> input)
	{
		this.myList = input;
		this.N = myList.size();
		// 여기서 초기 셋팅이 들어가야한다 거리 등.
	}
	
	public void Run()
	{
		result = 0; 
		// 여기서 실행하고
	}
	
	// We need to change this function!
	// Parameter가 추가되어야 한다
	public int Travel()
	{
		return 3;
	}
	
	

}
