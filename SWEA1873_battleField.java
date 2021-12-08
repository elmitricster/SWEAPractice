import java.util.Scanner;

public class SWEA1873_battleField {
	
	static int[][] dir = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; // 제자리, 동, 서, 남, 북
	static int H, W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			char[][] map = new char[H][W];
			
			int x = 0;
			int y = 0;
			int d = 0; // 1:동, 2:서, 3:남, 4:북
			
			for (int i = 0; i < H; i++) {
				String s = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
					switch (map[i][j]) {
					case '^':
						d = 4;
						break;
					case 'v':
						d = 3;
						break;
					case '<':
						d = 2;
						break;
					case '>':
						d = 1;
						break;
					}
				}
			}

			int N = sc.nextInt();

			String str = sc.next();

			for (int i = 0; i < N; i++) {
				char com = str.charAt(i);
				int nx, ny;

				if (com == 'U' || com == 'D' || com == 'L' || com == 'R') {
					if (com == 'U') {
						d = 4;
						map[x][y] = '^';
					} else if (com == 'D') {
						d = 3;
						map[x][y] = 'v';
					} else if (com == 'L') {
						d = 2;
						map[x][y] = '<';
					} else if (com == 'R') {
						d = 1;
						map[x][y] = '>';
					}

					nx = x + dir[d][0];
					ny = y + dir[d][1];

					if (isIn(nx, ny)) {
						if (map[nx][ny] == '.') {
							map[nx][ny] = map[x][y];
							map[x][y] = '.';
							x = nx;
							y = ny;
						}
					}
				} else if (com == 'S') {
					nx = x;
					ny = y;

					while (true) {
						nx += dir[d][0];
						ny += dir[d][1];
						if (!isIn(nx, ny) || map[nx][ny] == '#') {
							break;
						} else if (map[nx][ny] == '*') {
							map[nx][ny] = '.';
							break;
						}
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<H && y>=0 && y<W;
	}
	
}
