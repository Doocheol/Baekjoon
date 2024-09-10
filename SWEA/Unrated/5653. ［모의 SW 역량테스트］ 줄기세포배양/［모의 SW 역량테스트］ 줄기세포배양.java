import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {

    // 상, 하, 좌, 우 방향을 나타내는 배열, 세포가 번식할 때 사용
    static int[] dr = {-1, 1, 0, 0}; // 세포의 상하 이동 방향 (행)
    static int[] dc = {0, 0, -1, 1}; // 세포의 좌우 이동 방향 (열)
    static int N, M, K; // 세로(N), 가로(M), 배양 시간(K)

    // Cell 클래스 정의: 줄기세포의 위치(x, y), 생명력(life), 남은 시간(remainTime), 상태(state) 관리
    static class Cell implements Comparable<Cell> {
        int x, y, life, remainTime, state; // 세포의 좌표와 생명력, 남은 시간, 상태

        // Cell 생성자: 세포의 좌표(x, y)와 생명력(life)을 입력받아 초기화
        public Cell(int x, int y, int life) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.remainTime = life; // 비활성 상태에서는 남은 시간이 생명력과 동일함
            this.state = 0; // 초기 상태는 비활성 (0: 비활성, 1: 활성, 2: 죽음)
        }

        // 세포 정렬 기준 정의: 생명력이 큰 순으로, 생명력이 같으면 남은 시간이 적은 순으로 정렬
        @Override
        public int compareTo(Cell o) {
            if (this.life == o.life) { 
                return Integer.compare(o.remainTime, this.remainTime); // 남은 시간이 적은 세포가 먼저
            }
            return Integer.compare(o.life, this.life); // 생명력이 큰 세포가 먼저
        }
    }

    public static void main(String[] args) throws Exception {
 //       System.setIn(new FileInputStream("src/김두철/A준비/SWEA_5653_줄기세포배양.txt")); // 입력 파일 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위한 BufferedWriter
        StringBuilder sb = new StringBuilder(); // 출력 결과를 모아서 한 번에 출력

        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 개수 입력

        // 테스트 케이스 반복
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 세포 배양판의 세로 크기
            M = Integer.parseInt(st.nextToken()); // 세포 배양판의 가로 크기
            K = Integer.parseInt(st.nextToken()); // 배양 시간

            // 세포 배양판을 넉넉한 크기로 설정 (K 시간 후에도 번식 가능)
            int[][] map = new int[N + K * 2][M + K * 2]; // 중앙에 세포 배치
            List<Cell> cells = new ArrayList<>(); // 세포 정보를 저장할 리스트

            // 세포 초기 상태 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int life = Integer.parseInt(st.nextToken()); // 세포의 생명력 입력
                    if (life > 0) { // 생명력이 0보다 큰 경우에만 세포로 취급
                        map[i + K][j + K] = life; // 세포를 배양판의 중앙에서 시작
                        cells.add(new Cell(i + K, j + K, life)); // 세포 리스트에 추가
                    }
                }
            }

            // K시간 동안 시뮬레이션 수행
            for (int time = 1; time <= K; time++) {
                Collections.sort(cells); // 세포를 생명력 순으로 정렬

                List<Cell> newCells = new ArrayList<>(); // 새로 번식할 세포를 저장할 리스트

                for (Cell cell : cells) {
                    if (cell.state == 0) { // 세포가 비활성 상태인 경우
                    	cell.remainTime--;
                  
                        if (cell.remainTime == 0) { // 비활성 상태에서 남은 시간이 0이면 활성화
                            cell.state = 1; // 활성 상태로 변경
                            cell.remainTime = cell.life; // 활성 상태 유지 시간 설정
                        }
                    } else if (cell.state == 1) { // 세포가 활성 상태인 경우
                        if (cell.remainTime == cell.life) { // 활성화 후 첫 1시간 동안 번식
                            for (int d = 0; d < 4; d++) { // 상하좌우로 번식 시도
                                int nx = cell.x + dr[d]; // 새로운 세포의 x 좌표
                                int ny = cell.y + dc[d]; // 새로운 세포의 y 좌표
                                if (map[nx][ny] == 0) { // 번식할 위치가 비어 있는 경우
                                    map[nx][ny] = cell.life; // 해당 위치에 새로운 세포 배치
                                    newCells.add(new Cell(nx, ny, cell.life)); // 새로운 세포 리스트에 추가
                                }
                            }
                        }
                        
                        cell.remainTime--;
                        if (cell.remainTime == 0) { // 남은 시간이 0이면 세포가 죽음 상태로 전환
                            cell.state = 2; // 죽음 상태로 변경
                        }
                    }
                }

                // 새로운 세포 리스트를 기존 리스트에 추가
                cells.addAll(newCells);
            }

            // 죽지 않은 세포의 개수를 카운트
            int aliveCells = 0; // 살아있는 세포 개수
            for (Cell cell : cells) {
                if (cell.state != 2) aliveCells++; // 죽지 않은 세포만 카운트
            }

            // 테스트 케이스 결과 출력 형식 맞추기
            sb.append("#").append(tc).append(" ").append(aliveCells).append("\n"); // 결과 저장
        }

        bw.write(sb.toString()); // 결과 출력
        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 출력 스트림 닫기
        br.close(); // 입력 스트림 닫기
    }
}
