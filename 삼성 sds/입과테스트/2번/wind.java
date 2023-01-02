import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M, K;
    static int[][] arr = new int[101][101];
    static int answer;
    static String[] winds = {"동", "서", "남", "북"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                    answer = Math.max(arr[r][c], answer);
                }
            }

            // 1024개 순회해
            for (int j = 0; j < 1024; j++) {
                int[][] tmp = copy(arr);
                for (int k = 0; k < K; k++) {
                    // 보드로 wind에 넘기면서 업데이트해
                }
            }

            StringBuilder str = new StringBuilder();
            str.append('#').append(i).append(' ').append(answer);
            System.out.println(str.toString());
        }
    }
    
    static int[][] copy(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone(); 
        }
        return newArr;
    }

    // 1024개 경우의 수 만들었어? List로 나와
    static void recursive(int depth) {
        if (depth == K) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            wind(winds[i]);
            recursive(depth + 1);
        }
    }

    static void wind(String direction) {
        switch (direction) {
            case "동":
                break;
            case "서":
                break;
            case "남":
                break;
            case "북":
                break;
        }
    }
}
