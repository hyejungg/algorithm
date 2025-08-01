import java.util.*;
import java.lang.*;
import java.io.*;

// 이분탐색, 우선순위 큐?
/*
최소 1개, 최대 N개 공정 라인을 돌릴 수 있음. 
공정 라인 몇개 돌릴지 === 이분탐색으로 정해서 시뮬레이션 돌리기
시뮬레이션 돌리기 위해서 우선순위큐에 작은 순으로 넣어두고, 꺼내서 시간 쟤서 X 시간 내에 끝내는지 확인
*/
class Main {

    static int[] tasks;
    static int K;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tasks = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            tasks[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int answer = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                answer = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
            
        }
        System.out.println(answer);
    }

    static public boolean isPossible(int line) {
        // 누적 시간 저장
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(a, b));

        for (int i = 0; i < line; i++) {
            pq.add(0L);
        }

        for (int task : tasks) {
            long minTime = pq.poll();
            long finishTime = minTime + task;
            if (finishTime > K) {
                return false;
            }
            pq.add(finishTime);
        }
        
        return true;
    }
}