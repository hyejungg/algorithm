import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int[] nodes;
    static ArrayList<Edge> edges;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 수
        int M = Integer.parseInt(st.nextToken()); // 케이블 수
        K = Integer.parseInt(st.nextToken()); // 발전소 수

        nodes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int idx = Integer.parseInt(st.nextToken());
            nodes[idx] = -1; // 발전소 표시
        }

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges, (e1, e2) -> e1.weight - e2.weight);

        int ans = 0;
        for (Edge edge : edges) {
            int a = edge.start;
            int b = edge.end;
            if (find(a) != find(b)) {
                union(a, b);
                ans += edge.weight;
                if (isAllConnect()) break;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    public static int find(int x) {
        if (nodes[x] == -1) return -1;
        if (nodes[x] == x) return x;
        return nodes[x] = find(nodes[x]);
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        // 발전소 포함된 쪽을 루트로
        if (px == -1 || py == -1) {
            nodes[px == -1 ? py : px] = -1;
        } else {
            nodes[py] = px;
        }
    }

    public static boolean isAllConnect() {
        for (int i = 1; i <= N; i++) {
            if (find(i) != -1) return false;
        }
        return true;
    }
}
