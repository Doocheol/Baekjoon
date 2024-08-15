
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start_x = Integer.parseInt(st.nextToken());
		int start_y = Integer.parseInt(st.nextToken());
		
		int HOUR = Integer.parseInt(br.readLine());
		

        // 최종 위치 계산
        int final_x = (start_x + HOUR) % (2 * w);
        int final_y = (start_y + HOUR) % (2 * h);

        // 위치가 격자의 범위를 벗어나면 반사되어 위치를 조정
        if (final_x > w) {
        	final_x = 2 * w - final_x;
        }
        if (final_y > h) {
        	final_y = 2 * h - final_y;
        }

		sb.append(final_x).append(" ").append(final_y);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
