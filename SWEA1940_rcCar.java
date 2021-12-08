

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940_rcCar {
	static int type, vel, dis;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			vel = 0;
			dis = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				type = Integer.parseInt(st.nextToken());

				switch (type) {
				case 1:
					int accel1 = Integer.parseInt(st.nextToken());
					vel += accel1;
					break;
				case 2:
					int accel2 = Integer.parseInt(st.nextToken());
					vel -= accel2;
					if (vel < 0)
						vel = 0;
					break;
				case 0:
					
					break;
				}
				
				dis += vel;

			}

			System.out.println("#" + tc + " " + dis);
		}
		
	}

}
