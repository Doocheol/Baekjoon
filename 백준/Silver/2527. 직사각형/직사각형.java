
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 첫번째 직사각형 A의 좌표
            int A_x1 = Integer.parseInt(st.nextToken());
            int A_y1 = Integer.parseInt(st.nextToken());
            int A_x2 = Integer.parseInt(st.nextToken());
            int A_y2 = Integer.parseInt(st.nextToken());
            
            // 두번째 직사각형 B의 좌표
            int B_x1 = Integer.parseInt(st.nextToken());
            int B_y1 = Integer.parseInt(st.nextToken());
            int B_x2 = Integer.parseInt(st.nextToken());
            int B_y2 = Integer.parseInt(st.nextToken());
            
            // 공통부분이 없는 경우 : d 출력
            if (A_x2 < B_x1 || B_x2 < A_x1 || A_y2 < B_y1 || B_y2 < A_y1) {
                sb.append("d").append("\n");
            } 
            // 점에서 만나는 경우 : c 출력
            else if ((A_x2 == B_x1 && A_y2 == B_y1) || (A_x2 == B_x1 && A_y1 == B_y2) ||
                     (A_x1 == B_x2 && A_y2 == B_y1) || (A_x1 == B_x2 && A_y1 == B_y2)) {
                sb.append("c").append("\n");
            } 
            // 선분에서 만나는 경우 : b 출력
            else if (A_x2 == B_x1 || A_x1 == B_x2 || A_y2 == B_y1 || A_y1 == B_y2) {
                sb.append("b").append("\n");
            } 
            // 직사각형이 겹치는 경우 : a 출력
            else {
                sb.append("a").append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
