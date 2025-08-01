import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());        
        int K = Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());        
        }

        // 이분 탐색 범위 설정
        int left = 0;
        int right = Arrays.stream(score).sum();
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            // mid를 기준으로 그룹 개수 세기 (그룹합이 mid를 넘지 않도록 구성)
            int groupCount = 0;
            int sum = 0;
            for (int s : score) {
                sum += s;
                if (sum >= mid) {
                    groupCount++;
                    sum = 0;
                }
            }

            if (groupCount >= K) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
