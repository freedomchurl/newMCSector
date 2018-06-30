import java.util.ArrayList;

public abstract class Cluster {

	public static double lambda = 0.33;
	// 0.33m��� ����
	
	public static int SectorN = 4;
	// �켱 Sector�� 4���� �����Ѵٰ� �����Ѵ�.
	public boolean []isOn = null;
	// � Sector�� �����ִ��� �����ϱ� ���� �迭
	public int checkSector = 4;
	// ��� Sector�� �����ִ��� Ȯ���ϱ� ���� ����, ���������� 4�ǰ��� ������ ��� ���͸� Ű�Եȴ�.
	public static double Pt = 3;
	// Transfer power 3W
	public double Gt = 1;
	// Transfer Antenna Gain
	
	
	public double centerX;
	public double centerY;
	public double Radius;
	
	// ������ Smallest Circle�� �̿��� ����� ��尡 3���̻��� Circle��
	// �¾ƶ������� ��찡 �߾���.. �̰͵� �ϳ��� ������
	
	public ArrayList<Node> myNodes = new ArrayList<Node>();
	// ����ٰ� ������ �����Ѵ�.
	
	public double ConsumedCharging = 0;
	
	Cluster(Circle input)
	{
		this.centerX = input.centerX;
		this.centerY = input.centerY;
		this.Radius = input.Radius;
		this.myNodes = input.myNodes;
		// �״�� �����͸� Circle���� Cluster�� �Űܿ´�. ���õ� ���̵��̴ϱ�.
		
		isOn = new boolean[SectorN];
		// Sector�� ������ŭ isOn�� �����Ѵ�.
		Gt = SectorN / checkSector; 
		// ���������� SectorN�� ������ 4�̰�, checkSector�� ���� 4 -> Omni�� ��Ȳ�̶�� 4/4 = 1�� �ɰ��̰� 2���� ���������� 2�� ���� ������ ���̴�
	}
	
	Cluster()
	{
		
	}
	
	public int CheckSector()
	{
		int count = 0;
		
		for(int i=0;i<this.SectorN;i++) {
			if(isOn[i]==true)
				count++;
		}
		
		checkSector = count;
		return checkSector;
	}
	
	public int getNodesNum()
	{
		return myNodes.size();
		// Circle�� ����ִ� ����� ������ �����Ѵ�.
	}
	
	public abstract double CalRequiredEnergy();
	// �� �޼ҵ� ������ MC�� Static Pt�� Gt���� �̿��Ͽ�, MC�� �� Cluster�� �����ϴµ��� ���̴� �������� ����ؾ��Ѵ�.
	
}
