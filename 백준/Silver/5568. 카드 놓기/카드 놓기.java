import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<String> set = new HashSet<>(); // 슌열 저장
    static boolean[] visit; // 조합 때 사용할 방문 여부 배열
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        arr = new String[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        permutation(0, K, N, "");

        System.out.println(set.size());
    }
    public static void permutation(int cnt, int target, int N, String cur) {
        if (cnt == target) {
            set.add(cur);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(cnt + 1, target, N, cur + arr[i]);
                visit[i] = false;
            }
        }
    }
}