import java.util.ArrayList;

public class Simulator {
	
	public static double MoveEnergy = 5;
	// �ϴ��� 5J�� ����
	
	public static int NodeNum = 20;
	Node [] myNodes = new Node[NodeNum];
	// ��� 40���� �����
	
	
	public ArrayList<Circle> SingleCircle = new ArrayList<Circle>();
	// Single�� �׳� �״�� Circle�� ������ȴ�.
	public ArrayList<Cluster> SingleCluster = new ArrayList<Cluster>();
	// Single�� �״�� Cluster�� �ű��.
	
	
	public ArrayList<Circle> CandidateCircle = new ArrayList<Circle>();
	// ������, Multi����� ��� �Ѵ�, �ϴ� CandidateCircle�� �����, ���߿��� �����Ѵ�
	public ArrayList<Cluster> multiCluster = new ArrayList<Cluster>();
	
	public ArrayList<Circle> CandidateCircle_2 = new ArrayList<Circle>();
	// �������� ����� �����ϴ� ������ ���Ѵ�. Circle�� ������ �״�� �����ϰ� ��ó���� �ϸ�ȴ�.
	public ArrayList<Cluster> newmultiCluster = new ArrayList<Cluster>();
	// �Ʒ��� new ��� 
	
	public TSP myTSP = null;
	
	
	public double singleMoveDistance = 0;
	public double multiMoveDistance = 0;
	public double newMultiMoveDistance = 0;
	
	public double singleChargingEnergy = 0;
	public double multiChargingEnergy = 0;
	public double newMultiChargingEnergy = 0;
	
	public double singleTotalEnergy = 0;
	public double multiTotalEnergy = 0;
	public double newMultiTotalEnergy = 0;
	
	Simulator()
	{
		for(int i=0;i<NodeNum;i++)
		{
			myNodes[i] = new Node();
		}
	}
	
	
	public void Run()
	{
		RunSingle();
	}
	
	public void RunSingle()
	{
		MakeSingle();
		RoutingSingle();
		
		this.singleTotalEnergy = this.singleChargingEnergy + this.MoveEnergy * this.singleMoveDistance;
		// ��ü �Ҹ𿡳����� �̵��Ÿ� * ���ʹ� �̵� ������ + ��� Ŭ�����Ϳ��� ������ �Ҹ��� �������� ��
		
		System.out.println("�̵��Ÿ� = " + this.singleMoveDistance
				+ ", ���� �Ҹ𿡳��� = " + this.singleChargingEnergy);
	}
	
	
	public void RoutingSingle()
	{
		// �ռ��� ������� SingleCluster ArrayList�� �̿��Ͽ� �̵��� �ɸ��� �������� �̾ƺ���. 
		
		myTSP = new TSP(this.SingleCluster);
		myTSP.Run();
		this.singleMoveDistance = myTSP.finalResult;
		// ��ü ����� �����´�. ������ �Ÿ���.
		
		
	}
	
	public void MakeSingle()
	{
		Circle first = new Circle(0,0);
		// Single Charging���� ù��° ������
		this.SingleCircle.add(first); 
		SingleCluster firstCluster = new SingleCluster(first);
		this.SingleCluster.add(firstCluster);
		// �� ������ ��� ������ ������ �ȴ�. 
		
		for(int i=0;i<NodeNum;i++)
		{
			Circle tmp = new Circle(myNodes[i]);
			this.SingleCircle.add(tmp);
			// Single Circle�� �����
			SingleCluster tmpCluster = new SingleCluster(tmp);
			this.SingleCluster.add(tmpCluster);
			// Cluster�� �� ��´�.
		}
		
		//System.out.println("Cluster�� ������� = " + this.SingleCluster.size());
		//System.out.println("----------------------------------------------");
		
		double ChargingEnergy = 0;
		for(int i=1;i<this.SingleCluster.size();i++)
		{
			//System.out.println("Cluster�� ��� ������  = " + this.SingleCluster.get(i).getNodesNum() + " ����� �ʿ� ������ = " + this.SingleCluster.get(i).myNodes.get(0).requiredEnergy  + 
				//	" MC�� �Ҹ𿡳���  = " + this.SingleCluster.get(i).CalRequiredEnergy());
			ChargingEnergy += this.SingleCluster.get(i).CalRequiredEnergy();
		}
		
		System.out.println("Total ������ �ʿ� = " + ChargingEnergy);
		this.singleChargingEnergy = ChargingEnergy;
	}

}
