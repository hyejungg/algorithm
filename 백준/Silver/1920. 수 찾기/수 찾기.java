import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N]; // 상근이의 카드들
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());

            System.out.println(binarySearch(nArr, now));
        }
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (key == arr[mid]) {
                return 1;
            } else if (key < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
