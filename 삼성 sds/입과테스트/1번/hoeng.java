import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int C = Integer.parseInt(br.readLine());
            int[] inputNumbers = new int[C];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                inputNumbers[j] = Integer.parseInt(st.nextToken());
            }

            // 배열 순열 구하고 -> 각 순열마다 순서대로 제곱근 체크 -> true인거 카운트 세기
            int[] output = new int[C];
            boolean[] visit = new boolean[C];

            List<List<Integer>> numbers = new ArrayList<>();
            permutation(numbers, inputNumbers, output, visit, 0, C, factorial(C - 1));

            int count = 0;
            count = Math.max(count, checkSumSquareRoot(numbers));

            StringBuilder str = new StringBuilder();
            str.append('#').append(i).append(' ').append(count);
            System.out.println(str.toString());
        }
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return n;
        }
        return factorial(n - 1) * n;
    }

    public static void permutation(List<List<Integer>> numbers, int[] inputNumbers, int[] output, boolean[] visit,
            int depth, int r, int size) {
        if (depth == r) {
            numbers.add(newInstance(output, r));
            return;
        }
        for (int i = 0; i < inputNumbers.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = inputNumbers[i];
                if (numbers.size() < size) {
                    permutation(numbers, inputNumbers, output, visit, depth + 1, r, size);
                }
                visit[i] = false;
            }
        }
    }

    public static ArrayList<Integer> newInstance(int[] arr, int r) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            arrayList.add(arr[i]);
        }
        return arrayList;
    }

    public static int checkSumSquareRoot(List<List<Integer>> numbers) {
        int totalCount = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int roundCount = 0;
            for (int j = 1; j < numbers.get(i).size(); j++) {
                int sum = (numbers.get(i).get(j - 1)) + (numbers.get(i).get(j));
                if (Math.sqrt(sum) % 1 == 0) {
                    roundCount++;
                }
                if (j == numbers.get(i).size() - 1) {
                    sum = (numbers.get(i).get(j)) + (numbers.get(i).get(0));
                    if (Math.sqrt(sum) % 1 == 0) {
                        roundCount++;
                    }
                }
            }
            totalCount = Math.max(roundCount, totalCount);
        }
        return totalCount;
    }
}
