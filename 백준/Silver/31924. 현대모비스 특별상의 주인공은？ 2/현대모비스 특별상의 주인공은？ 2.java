import java.io.*;

public class Main {

	static int n = 0;
	static int count = 0;
	static int[] rx = { 1, 2, 3, 4 };
	static int[] uy = { -1, -2, -3, -4 };
	static int[] dy = { 1, 2, 3, 4 };
	static char[] mobis = { 'O', 'B', 'I', 'S' };
	static char[] sibom = { 'I', 'B', 'O', 'M' };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		n = Integer.parseInt(br.readLine().trim());
		
		String line;
		map = new char[n][n];
		
		for (int r = 0; r < n; r++) {
			line = br.readLine().trim();
			for (int c = 0; c < n; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == 'M') {
					mobis(r, c);
				} else if (map[r][c] == 'S') {
					sibom(r, c);
				}
			}
		}
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void mobis(int y, int x) {
		int index = 0;
		int nowy = y;
		int nowx = x;
		int nexty, nextx;

		// 오른쪽 위
		for (int i = 0; i < 4; i++) {
			nexty = nowy + uy[i];
			nextx = nowx + rx[i];

			if (check(nexty, nextx) && map[nexty][nextx] == mobis[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}

		// 오른쪽
		index = 0;
		for (int i = 0; i < 4; i++) {
			nextx = nowx + rx[i];

			if (check(nowy, nextx) && map[nowy][nextx] == mobis[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}

		// 오른쪽 아래
		index = 0;
		for (int i = 0; i < 4; i++) {
			nexty = nowy + dy[i];
			nextx = nowx + rx[i];

			if (check(nexty, nextx) && map[nexty][nextx] == mobis[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}

		// 아래
		index = 0;
		for (int i = 0; i < 4; i++) {
			nexty = nowy + dy[i];

			if (check(nexty, nowx) && map[nexty][nowx] == mobis[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}
	}

	private static void sibom(int y, int x) {
		int index = 0;
		int nowy = y;
		int nowx = x;
		int nexty, nextx;

		// 오른쪽 위
		for (int i = 0; i < 4; i++) {
			nexty = nowy + uy[i];
			nextx = nowx + rx[i];

			if (check(nexty, nextx) && map[nexty][nextx] == sibom[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}

		// 오른쪽
		index = 0;
		for (int i = 0; i < 4; i++) {
			nextx = nowx + rx[i];

			if (check(nowy, nextx) && map[nowy][nextx] == sibom[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}

		// 오른쪽 아래
		index = 0;
		for (int i = 0; i < 4; i++) {
			nexty = nowy + dy[i];
			nextx = nowx + rx[i];

			if (check(nexty, nextx) && map[nexty][nextx] == sibom[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}

		// 아래
		index = 0;
		for (int i = 0; i < 4; i++) {
			nexty = nowy + dy[i];

			if (check(nexty, nowx) && map[nexty][nowx] == sibom[index]) {
				index++;

				if (index == 4) {
					count++;
				}
			} else {
				break;
			}
		}
	}

	// 격자판 안에 있는지 체크하는 함수
	private static boolean check(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}
}
