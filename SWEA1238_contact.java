import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238_contact {
	static int[] distance;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[101];
			distance = new int[101];
			Arrays.fill(distance, -1);
			
			for (int i = 1; i < 101; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N / 2; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
			}
			
			int answer = bfs(start);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");	
		}
		System.out.print(sb);
	}
	
	static int bfs(int start) {
		distance[start] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if(distance[next] == -1) {
					distance[next] = distance[now] + 1;
					q.offer(next);
				}
			}
		}
		
		int maxDistance = Integer.MIN_VALUE;
		int answer = 0;
		
		for (int i = 1; i < 101; i++) {
			if (maxDistance <= distance[i]) {
				maxDistance = distance[i];
				answer = i;
			}
		}
		return answer;
	}

}
