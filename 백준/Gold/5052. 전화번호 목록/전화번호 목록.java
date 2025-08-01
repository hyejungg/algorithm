import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] numbers = new String[N];
 
            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }
            Arrays.sort(numbers);

            boolean isInclude = true;
            for(int i = 0; i < N - 1; i++) {
                if(numbers[i + 1].startsWith(numbers[i])) {
                    isInclude = false;
                    break;
                }
            }
            if (isInclude == false) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}