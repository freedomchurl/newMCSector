import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class TSP {

	public ArrayList<Cluster> myList = null;
	public double result = 0;
	// ó������ �Ÿ�, �׷��� ���߿� �����˰���ó�� �����Ϸ��� ���ο� Parameter�� �߰��Ͽ��� �Ѵ�.

	public int N = 0;

	public double finalResult = 0;

	public final double NO = 0;

	//
	public int index;
	public Vector<Double> v = new Vector<Double>();
	public int cities;
	public int[] visited = null;
	//
	public double Dis[][] = null;

	TSP() {

	}

	TSP(ArrayList<Cluster> input) {
		this.result = 0;
		this.cities = 1;
		this.index = 0;
		this.myList = input;
		this.N = myList.size();
		//System.out.println("N size = " + N);
		this.Dis = new double[this.N][this.N];
		this.visited = new int[this.N];
		//System.out.println("visited length = " + visited.length);
		// ���⼭ �ʱ� ������ �����Ѵ� �Ÿ� ��.

		// �Ÿ� �迭�� ä���־���Ѵ�.

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// ���⼭ �Ÿ����͸� ä��������
				this.Dis[i][j] = Math.sqrt(Math.pow(myList.get(i).centerX - myList.get(j).centerX, 2)
						+ Math.pow(myList.get(i).centerY - myList.get(j).centerY, 2));
			}
		}

	}

	public void Run() {
		result = 0;
		Travel(0);
		// ���⼭ �����ϰ�
		this.getValue();
		// �̰� �����ϸ� ����, v.elementAt(0); �� ��ü �̵��Ÿ�

		this.finalResult = v.elementAt(0);
	}

	// We need to change this function!
	// Parameter�� �߰��Ǿ�� �Ѵ�
	public void Travel(int cur) // int cur == ���� ���� �ε���
	{
		int i, j;

		if (this.cities == N && this.Dis[cur][0] != 0) {
			this.v.addElement(result + this.Dis[cur][0]);
			return;
		}

		for (i = 1; i < N; ++i) {
			if (i == cur) {
				continue;
			}

			// System.out.println("cur = " + cur + " i = " + i);
			if (this.Dis[cur][i] != this.NO && visited[i] == 0) {
				this.visited[i] = 1;
				cities++;
				result += Dis[cur][i];
				Travel(i);

				cities--;
				visited[i] = 0;
				result -= this.Dis[cur][i];
			}
		}
	}

	public void getValue() {
		int i;

		Collections.sort(this.v); // vector �������� ����
		System.out.println("���� ũ�� " + v.size());
		System.out.println("�̵��Ÿ� " + v.elementAt(0));
	}

}
