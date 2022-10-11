import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // input
        StringBuilder answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 상근이의 숫자 카드의 개수
        int[] nArr = new int[N]; // 상근이의 카드들
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        // search
        Arrays.sort(nArr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int curr = Integer.parseInt(st.nextToken());
            answer.append(Math.abs(lowerBoundBinarySearch(nArr, curr) - upperBoundBinarySearch(nArr, curr)) + " ");
        }

        System.out.println(answer.toString());
    }

    public static int lowerBoundBinarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (left < right) {
            int mid = (left + right) / 2; // 중간위치를 구한다.

            if (key <= arr[mid]) {
                right = mid;
            }

            else {
                left = mid + 1;
            }

        }
        return left;
    }

    public static int upperBoundBinarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (left < right) {
            int mid = (left + right) / 2; // 중간위치를 구한다.

            if (key < arr[mid]) { //초과 해야 하니까
                right = mid;
            }

            else {
                left = mid + 1;
            }

        }
        return left;
    }
}
