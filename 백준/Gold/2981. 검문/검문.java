import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] diff = new int[N + 1];
        
        Arrays.sort(diff);

        // 두 수의 차이를 구하기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i != 0) {
                diff[i - 1] = Math.abs(arr[i] - arr[i-1]);
            }
        }

        int g = diff[0];
        // 두 수 간의 최대 공약수를 구하기
        for (int i = 0; i < N; i++) {
            g = gcd(g, diff[i]);
        }

        
        StringBuffer sb = new StringBuffer();
        for (int i = 2; i <= g; i++) {
            if (g % i == 0) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
    
    static int gcd(int a, int b){
        // 나머지가 0 일 때 그 몫이 되는 a 를 출력
        while (b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}