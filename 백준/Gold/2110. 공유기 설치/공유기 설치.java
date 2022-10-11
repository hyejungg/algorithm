import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
        int [] arr = new int[N]; // 집의 좌표
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // search
        Arrays.sort(arr);
        int answer = 0;
        int start = 0;
        int end = arr[arr.length - 1];
        while(start <= end) {
            int mid = (start + end) / 2; // 탐색 기준 == 최소 거리

            int installCnt = 1;
            int lastInstall = arr[0]; // 첫번째 집은 무조건 설치했다고 봄
            for (int locate : arr) {
                // 두 집 사이의 거리가 mid 보다 크거나 같다면 설치
                if (locate - lastInstall >= mid) {
                    installCnt++;
                    lastInstall = locate;
                }
            }
            
            if (installCnt >= C) {
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
