import java.util.*;

class Solution {
    class Job implements Comparable<Job> {

        private int waitTime; // 기다리는 시간
        private int progressTime; // 작업 시간

        public Job(int waitTime, int progressTime) {
            this.waitTime = waitTime;
            this.progressTime = progressTime;
        }

        public int getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(int waitTime) {
            this.waitTime = waitTime;
        }

        public int getProgressTime() {
            return progressTime;
        }

        public void setProgressTime(int progressTime) {
            this.progressTime = progressTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.waitTime - o.waitTime;
        }
    }

    public int solution(int[][] jobs) {
        // 우선 요청 시간 기준으로 오름차순 정렬해
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        Queue<Job> waitingQueue = new LinkedList<>(); // 작업 큐
        PriorityQueue<Job> readyQueue = new PriorityQueue<>(
            Comparator.comparingInt(Job::getProgressTime)); // 작업 시간 기준 우선순위 큐

        // 작업 큐에 넣어
        for (int i = 0; i < jobs.length; i++) {
            waitingQueue.add(new Job(jobs[i][0], jobs[i][1]));
        }

        int cnt = 0; // 실행된 작업의 개수
        int currentTime = 0;
        int totalTime = 0;

        while (cnt < jobs.length) {
            while (!waitingQueue.isEmpty() && waitingQueue.peek().getWaitTime() <= currentTime) {
                readyQueue.add(waitingQueue.poll());
            }

            // 우선순위 큐에 값이 있다 == 처리해야 할 job이 있다.
            if (!readyQueue.isEmpty()) {
                Job now = readyQueue.poll();

                totalTime += now.getProgressTime() + (currentTime - now.getWaitTime());
                currentTime += now.getProgressTime();
                cnt++;
            } else {
                currentTime++;
            }
        }

        return totalTime / cnt;
    }
}