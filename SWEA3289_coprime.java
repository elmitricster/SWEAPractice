import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289_coprime {
	static int[] parent, rank;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 정점 (100만개)
			int M = Integer.parseInt(st.nextToken()); // 명령어 (10만개)
			
			// 서로소 원소 초기화: 자기 자신을 부모로 갖게하고 트리깊이를 0으로 초기화
			parent = new int[N+1];
			rank = new int[N+1];
			for (int x = 1; x <= N; x++)
				makeSet(x);
			
			// 명령어 실행
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (command == 0)
					union(a, b);
				else if (command == 1) {
					int pa = findSet(a);
					int pb = findSet(b);
					sb.append((pa == pb) ? 1 : 0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 초기화 메서드
	public static void makeSet(int x) {
		parent[x] = x; // 부모를 자신의 index로 표기
		rank[x] = 0; // 깊이 저장. 초기 값은 0
	}
	
	// 일반 멤버 x를 포함하는 집합의 대표자 index를 리턴
	public static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}
	
	// 일반 멤버 x, 일반멤버 y를 포함하는 두 집합을 통합
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		// x, y의 대표자 집합을 rank 값을 기준으로 합침. 깊은 쪽을 대표자로 설정
		if (rank[px] < rank[py])
			parent[px] = py;
		else {
			parent[py] = px;
			if (rank[px] == rank[py]) // 깊이가 같은 경우 랭크 값을 증가시킨다.
				rank[px]++;
		}
	}

}
