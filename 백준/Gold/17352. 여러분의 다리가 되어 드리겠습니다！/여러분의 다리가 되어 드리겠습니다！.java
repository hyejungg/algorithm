import java.util.*;
import java.lang.*;
import java.io.*;

// bfs, dfs 아무거나 노드 하나만 뽑아 연결하면 됨 -> dfs 써야징
class Main {

    static List<List<Integer>> graph;
    static boolean visited[];
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        
        // node 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 간 연결
        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int start = find();
        dfs(start);
        int end = find();
        
        System.out.println(start + " " + end);
        
    }

    static public void dfs (int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static int find() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return i;
        }
        return -1;
    }
}