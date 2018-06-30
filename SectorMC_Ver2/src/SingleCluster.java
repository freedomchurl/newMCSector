
public class SingleCluster extends Cluster{
	
	SingleCluster(Circle input)
	{
		super(input);
	}

	@Override
	public double CalRequiredEnergy() {
		// TODO Auto-generated method stub
		// �̰� SingleCharging�̴ϱ�, ����� ������ �Ѱ��� �ᱹ Charging�� �ʿ��� �������� �׳� �״�� Friis Eq.
		
		this.checkSector = 1; // 1���� Sector�� ������ȴ�.
		this.Gt = this.SectorN / this.checkSector;
		
		if(this.myNodes.size()==0)
		{
			// ù���� ��带 ���� ����
			
			this.ConsumedCharging = 0;
			
			return 0;
		}
		else
		{
			double re = this.myNodes.get(0).requiredEnergy;
			// �ʿ信����
			
			double receive = this.Gt * Node.Gr * Math.pow((Cluster.lambda / (4*Math.PI * (Node.Beta))),2) * Cluster.Pt;
			
			double rate = re / receive;
			// �ʿ��� �������� ���� -> �ð��̶�� �� �� �ִ�.
			
			this.ConsumedCharging = (rate * Cluster.Pt);
			
			return (rate * Cluster.Pt);
			// �� �Ҹ� ������
		}
	}
	
	

}
