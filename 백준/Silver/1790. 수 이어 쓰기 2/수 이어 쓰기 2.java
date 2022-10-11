import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringTokenizer에 토큰으로 문자열을 나눠 저장했으니 변수에 넣을때는 형변환을 해줘야한다.
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1 의 자리 : 1~9 (9개), 10의 자리 : 10 ~ 99(90개), 100의 자리 : 100 ~ 999(90개)
        long finalNum = 0;
        long numLength = 1;
        long numCnt = 9;

        // 숫자의 개수는 다음 범위로 증가할 때마다 *10이 되고, 길이는 +1이 됨
        while (K > numLength * numCnt) {
            K -= (numLength * numCnt);
            finalNum += numCnt;
            numLength++;
            numCnt *= 10;
        }

        finalNum = (finalNum + 1) + (K - 1) / numLength;

        if (finalNum > N) {
            System.out.println(-1);
        } else {
            int index = (int) ((K - 1) % numLength);
            System.out.println(String.valueOf(finalNum).charAt(index));
        }
    }
}
