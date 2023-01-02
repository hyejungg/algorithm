import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotateArr(N, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateArr(int N, int M) {
        int check = Math.min(N, M) / 2; // 돌려야 할 사각형의 개수 -- 제한조건

        for (int cnt = 0; cnt < check; cnt++) {
            int nMax = N - cnt - 1;
            int mMax = M - cnt - 1;

            int temp = arr[cnt][cnt];
            // 위쪽 변 : 왼 <- 오
            for (int i = cnt; i < mMax; i++) {
                arr[cnt][i] = arr[cnt][i+1];
            }
            // 오른쪽 변 : 아래 <- 위
            for (int i = cnt; i < nMax; i++) {
                arr[i][mMax] = arr[i + 1][mMax];
            }
            // 아래쪽 변 : 왼 -> 오
            for (int i = mMax; i > cnt; i--) {
                arr[nMax][i] = arr[nMax][i - 1];
            }
            // 왼쪽 변 : 위 -> 아래
            for (int i = nMax; i > cnt; i--) {
                arr[i][cnt] = arr[i - 1][cnt];
            }
            arr[cnt+1][cnt] = temp;
        }
    }
}