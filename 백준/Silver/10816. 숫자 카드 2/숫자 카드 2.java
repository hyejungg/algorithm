import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 상근이의 숫자 카드의 개
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        HashMap<Integer, Integer> map = new HashMap<>(); // key: 숫자, value: 개수
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            answer.append(map.getOrDefault(input, 0) + " ");
        }

        System.out.println(answer.toString());
    }
}
