import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 상근이가 가져 갈 나무의 길이
        int[] arr = new int[N];

        // input
        st = new StringTokenizer(br.readLine(), " "); // 다시 다음 줄에 여러 개로 입력받을거니까 다시 초기화
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);
        long start = 0;
        long end = arr[arr.length - 1];
        long answer = 0;

       // search
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0)
                    sum += (arr[i] - mid); // 상근이가 가져갈 수 있는 나무의 길이 합
            }

            if (sum >= M) {
                start = mid + 1;
                answer = start;
            } else {
                end = mid - 1;
            }

        }

        // output
        System.out.println(answer - 1);
    }
}
