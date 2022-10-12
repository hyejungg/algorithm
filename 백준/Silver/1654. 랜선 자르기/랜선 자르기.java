import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long start = 1;

        // input
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long end = arr[arr.length - 1];
        long answer = 0;

       // search
        while (start <= end) {
            long mid = (start + end) / 2; // 자른 랜선의 길이
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += (arr[i] / mid); // 해당 랜선을 길이만큼 잘랐을 때 몇개 나왕?
                if (sum > N) break;
            }

            if (sum >= N) {
                start = mid + 1; //길이를 더 늘려서 재탐색할거야
                answer = mid;
            } else {
                end = mid - 1; //길이를 줄여서 재탐색할꺼야
            }
        }

        // output
        System.out.println(answer);
    }
}
