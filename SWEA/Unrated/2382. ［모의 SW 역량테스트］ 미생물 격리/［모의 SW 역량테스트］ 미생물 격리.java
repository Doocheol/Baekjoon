
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int N, M, K;
    static int[] dr = {0, -1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, 0, -1, 1}; // 상, 하, 좌, 우

    static List<Microbe> microbes;

    public static void main(String[] args) throws Exception {

//        System.setIn(new FileInputStream("src/김두철/A075.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]); // 맵 크기
            M = Integer.parseInt(line[1]); // 격리 시간
            K = Integer.parseInt(line[2]); // 미생물 군집 수

            microbes = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int numbers = Integer.parseInt(input[2]);
                int direction = Integer.parseInt(input[3]);
                microbes.add(new Microbe(x, y, numbers, direction));
            }

            // M시간 동안 미생물 이동 처리
            for (int time = 0; time < M; time++) {
                moveMicrobes();
                mergeMicrobes();
            }

            // 남은 미생물 수 계산
            int result = 0;
            for (Microbe microbe : microbes) {
                result += microbe.numbers;
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 미생물 이동 처리
    private static void moveMicrobes() {
        for (Microbe microbe : microbes) {
            int nx = microbe.x + dr[microbe.direction];
            int ny = microbe.y + dc[microbe.direction];

            // 경계에 도착한 경우 처리
            if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
                microbe.numbers /= 2; // 절반으로 감소
                microbe.direction = changeDirection(microbe.direction); // 방향 전환
            }

            microbe.x = nx;
            microbe.y = ny;
        }
    }

    // 미생물 군집 병합 처리
    private static void mergeMicrobes() {
        int[][] board = new int[N][N]; // 각 위치에 가장 큰 군집의 번호 기록
        List<Microbe>[][] tempBoard = new ArrayList[N][N]; // 각 위치에 미생물 군집 리스트 저장

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempBoard[i][j] = new ArrayList<>();
            }
        }

        for (Microbe microbe : microbes) {
            tempBoard[microbe.x][microbe.y].add(microbe);
        }

        List<Microbe> newMicrobes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempBoard[i][j].size() == 1) {
                    newMicrobes.add(tempBoard[i][j].get(0)); // 한 군집만 있는 경우 그대로 유지
                } else if (tempBoard[i][j].size() > 1) {
                    int totalNumbers = 0;
                    int maxNumbers = 0;
                    Microbe strongest = null;

                    // 병합 처리
                    for (Microbe microbe : tempBoard[i][j]) {
                        totalNumbers += microbe.numbers;
                        if (microbe.numbers > maxNumbers) {
                            maxNumbers = microbe.numbers;
                            strongest = microbe; // 가장 큰 군집 저장
                        }
                    }

                    strongest.numbers = totalNumbers; // 병합된 수로 갱신
                    newMicrobes.add(strongest); // 가장 큰 군집만 추가
                }
            }
        }

        microbes = newMicrobes; // 갱신된 미생물 리스트로 교체
    }

    // 방향 전환 함수
    private static int changeDirection(int direction) {
        if (direction == 1) direction = 2;
        else if (direction == 2) direction = 1;
        else if (direction == 3) direction = 4;
        else if (direction == 4) direction = 3;
        return direction;
    }

    // 미생물 클래스
    static class Microbe {
        int x, y, numbers, direction;

        public Microbe(int x, int y, int numbers, int direction) {
            this.x = x;
            this.y = y;
            this.numbers = numbers;
            this.direction = direction;
        }
    }
}
