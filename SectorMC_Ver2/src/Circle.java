import java.util.ArrayList;

public class Circle {

	public double centerX;
	public double centerY;
	public double Radius;
	
	// 기존의 Smallest Circle을 이용한 방법은 노드가 3개이상인 Circle이
	// 맞아떨어지는 경우가 잘없어.. 이것도 하나의 문제지
	
	public ArrayList<Node> myNodes = new ArrayList<Node>();
	// 여기다가 노드들을 저장한다.
	
	Circle()
	{
		
	}
	
	Circle(Node input)
	{
		// Single Node를 위한 생성자
		this.centerX = input.x;
		this.centerY = input.y;
		this.Radius = 0; // single charging 이니까 거리가 0
		myNodes.add(input);
		// input 노드를 ArrayList에 넣는다. 이때, Node 객체가 공유되고있음을 명심하자
	}
	Circle(int x,int y)
	{
		// 처음 노드를 넣기 위함
		this.centerX = x;
		this.centerY = y;
		this.Radius = 0;
		// 이때는, myNodes의 노드의 개수가 0이다 이걸 이용하자
	}
}
