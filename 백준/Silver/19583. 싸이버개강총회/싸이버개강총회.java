import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken(); // 시작 시간
        String E = st.nextToken(); // 끝난 시간
        String Q = st.nextToken(); // 스트리밍 종료 시간

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nicknames = new HashSet<>();

        // 입력을 더이상 받지 않을 때까지 진행
        String str = "";
        while ((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            String time = arr[0];
            String nickname = arr[1];

            nicknames.add(nickname);

            if (S.compareTo(time) >= 0) {
                before.add(nickname);
            } else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                after.add(nickname);
            }
        }

        int answer = 0;
        for (String nickname : nicknames) {
            if (before.contains(nickname) && after.contains(nickname))
                answer++;
        }

        System.out.println(answer);
    }
}