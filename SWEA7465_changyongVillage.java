import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7465_changyongVillage {
	static int T, N, M, answer;
	static int parent[], rank[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			
			parent = new int[N+1];
			rank = new int[N+1];
			
			for (int i = 0; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			for (int i = 1; i <= N; i++) {
				if(parent[i] == i)
					answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static int findSet(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = findSet(parent[a]);
	}
	
	public static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		if (rank[pa] < rank[pb]) {
			parent[pa] = pb;
		}
		else {
			parent[pb] = pa;
			if (rank[pa] == rank[pb])
				rank[pb]++;
		}
	}

}
