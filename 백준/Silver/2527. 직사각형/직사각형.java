import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 첫번째 직사각형 좌표
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            
            // 두번째 직사각형 좌표
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());
            
            // 공통부분이 없는 경우 (x1 > x4 or x3 < x2 or y1 > y4 or y3 < y2)
            if (x3 < x2 || x4 < x1 || y3 < y2 || y4 < y1) {
                sb.append("d\n");
            } 
            // 점에서 만나는 경우
            else if ((x3 == x2 && y3 == y2) || (x3 == x2 && y1 == y4) ||
                     (x1 == x4 && y3 == y2) || (x1 == x4 && y1 == y4)) {
                sb.append("c\n");
            } 
            // 선분에서 만나는 경우
            else if (x3 == x2 || x1 == x4 || y3 == y2 || y1 == y4) {
                sb.append("b\n");
            } 
            // 직사각형이 겹치는 경우
            else {
                sb.append("a\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
