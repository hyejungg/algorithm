import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine()); // 찾고자 하는 값

        arr = new int[N][N];
        List<Integer> pos = new ArrayList<>(); // P의 x, y 위치 저장

        makeArr(N);

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                str.append(arr[i][j] + " ");
                if (arr[i][j] == K) {
                    pos = Arrays.asList(i+1, j+1);
                }
            }
            str.append("\n");
        }
        str.append(pos.get(0) + " " + pos.get(1));
        System.out.println(str.toString());
    }

    public static void makeArr(int N) {
        int value = N*N;
        int x = 0, y = 0;
        int time = 0, limit = N;
        while (value > 0) {
            x = time;
            // 하
            for (int i = y; i < limit; i++) {
                arr[i][x] = value--;
            }
            y = limit - 1;
            // 우
            for (int i = x + 1; i < limit; i++) {
                arr[y][i] =  value--;
            }
            x = limit - 1;
            // 상
            for (int i = y-1; i >= time; i--) {
                arr[i][x] =  value--;
            }
            y = time;
            // 좌
            for (int i = x-1; i > time; i--) {
                arr[y][i] =  value--;
            }
            time++;
            limit--;
            y = time;
        }
    }
}