import java.util.ArrayList;

public class TSP {
	
	public ArrayList<Cluster> myList = null;
	public double result = 0;
	// ó������ �Ÿ�, �׷��� ���߿� �����˰���ó�� �����Ϸ��� ���ο� Parameter�� �߰��Ͽ��� �Ѵ�.
	
	public int N = 0;
	
	
	TSP()
	{
		
	}
	
	TSP(ArrayList<Cluster> input)
	{
		this.myList = input;
		this.N = myList.size();
		// ���⼭ �ʱ� ������ �����Ѵ� �Ÿ� ��.
	}
	
	public void Run()
	{
		result = 0; 
		// ���⼭ �����ϰ�
	}
	
	// We need to change this function!
	// Parameter�� �߰��Ǿ�� �Ѵ�
	public int Travel()
	{
		return 3;
	}
	
	

}
