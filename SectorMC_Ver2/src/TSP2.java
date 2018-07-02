import java.util.Arrays;

public class TSP2 {
	public static double[][] W;
	public static double[][] dp;
	public static int N;
	public static final double INF = 1000000000;
	/**
	 * 
	 * @param start ������
	 * @param visited ������� ���
	 * @return
	 */
	public static double getShortestPath(int current, int visited) {
		
		// ��� ������ �� �鸥 ���
		if (visited == (1 << N) - 1)
			return W[current][1];

		// �̹� �鷶�� ����̹Ƿ� �ٷ� return
		if (dp[current][visited] >= 0)
			return dp[current][visited];

		double ret = INF;

		// ���տ��� ������ �� ���Ҹ� ����!
		for (int i = 1; i <= N; i++) {
			int next = i;

			if ((visited & (1 << (next - 1))) != 0) // �߿�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				continue;
			
			if(W[current][next] == 0) // 0�� ��ΰ� �����Ƿ� pass
				continue;
			
			double temp = W[current][next] + getShortestPath(next, visited + (1 << (next - 1)));
			ret = Math.min(ret, temp);
		}

		return dp[current][visited] = ret;

	}

	public static void main(String[] args) {
		
		N = 30;
		
		double [] x = new double[N+1];
		double [] y = new double[N+1];
		
		for(int i=1;i<N+1;i++)
		{
			x[i] = (Math.random() * 40) - 20;
			// -20~20
			y[i] = (Math.random() * 40) - 20;
			// -20~20
			x[1] = 0;
			y[1] = 0;
			// 1������ 0,0;
		}
		

		System.out.printf("aaaa = %d\n",1<<N);
		W = new double[N + 1][N + 1];
		dp = new double[N + 1][1 << N];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				W[i][j] = Math.sqrt(Math.pow(x[i] - x[j], 2)
						+ Math.pow(y[i] - y[j], 2));
			}
		}
		
				
		// 2���� �迭�� ��� ���Ҹ� -1��
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int start = 1;
		System.out.println(getShortestPath(start, 1));

	}

}