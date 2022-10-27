import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int answer = 1;

        if (num == 1) {
            System.out.println(answer);
            return;
        }

        int range = 2; // num의 범위
        while (range <= num) {
            range = range + (6 * answer);
            answer++;
        }
        System.out.println(answer);
    }
}