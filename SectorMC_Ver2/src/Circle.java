import java.util.ArrayList;

public class Circle {

	public double centerX;
	public double centerY;
	public double Radius;
	
	// ������ Smallest Circle�� �̿��� ����� ��尡 3���̻��� Circle��
	// �¾ƶ������� ��찡 �߾���.. �̰͵� �ϳ��� ������
	
	public ArrayList<Node> myNodes = new ArrayList<Node>();
	// ����ٰ� ������ �����Ѵ�.
	
	Circle()
	{
		
	}
	
	Circle(Node input)
	{
		// Single Node�� ���� ������
		this.centerX = input.x;
		this.centerY = input.y;
		this.Radius = 0; // single charging �̴ϱ� �Ÿ��� 0
		myNodes.add(input);
		// input ��带 ArrayList�� �ִ´�. �̶�, Node ��ü�� �����ǰ������� �������
	}
	Circle(int x,int y)
	{
		// ó�� ��带 �ֱ� ����
		this.centerX = x;
		this.centerY = y;
		this.Radius = 0;
		// �̶���, myNodes�� ����� ������ 0�̴� �̰� �̿�����
	}
}
