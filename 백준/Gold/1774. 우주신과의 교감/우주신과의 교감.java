import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 크루스칼 알고리즘 MST

public class Main {
	static class God {
		int x;
		int y;

		God(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double weight;

		Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// this.weight < o.weight 가 음수 -> this.weight
			// this.weight > o.weight 가 양수 -> o.weight
			// this.weight == o.weight 가 0 -> 0
			return Double.compare(this.weight, o.weight);
		}
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 우주신들의 개수
		int M = Integer.parseInt(st.nextToken()); // 연결된 신들과의 통로 개수

		List<God> gods = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			gods.add(new God(x, y));
		}

		// 각 정점의 부모를 표현한 배열 (오름차순으로 들어간 상태)
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			union(parent, x, y);
		}

		// 각 우주신들 사이의 거리가 작을수록 먼저 처리되도록 우선순위 큐 사용
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 각 우주신들 사이의 거리를 계산하여 우선순위 큐에 저장
		for (int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				double distance = getDistance(gods.get(i).x, gods.get(i).y, gods.get(j).x, gods.get(j).y);
				pq.offer(new Edge(i, j, distance));
			}
		}

		double cost = 0.0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int rootA = find(parent, edge.from);
			int rootB = find(parent, edge.to);

			if (rootA != rootB) {
				union(parent, rootA, rootB);
				cost += edge.weight;
			}
		}

		System.out.printf("%.2f\n", cost);
	}

	static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	static int find(int[] parent, int x) {
		// 부모 노드를 찾았다면 그 값을 반환
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent, parent[x]);
	}

	static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);
		// 서로 부모가 다르면 합치기. 작은 값이 루트 노드가 되게
		if (rootA < rootB) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
		}
	}
}
