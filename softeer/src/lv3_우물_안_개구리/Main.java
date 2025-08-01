package lv3_우물_안_개구리;
import java.io.*;
import java.util.*;

/**
 * https://softeer.ai/practice/6289
 */

public class Main {
	public static class User {
		int no;
		int weight;
		Set<User> neighbor = new HashSet<>();

		public User(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		public void addNeighbor(User user) {
			neighbor.add(user);
		}
	}

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Map<Integer, User> users = new HashMap<>();
		for (int i = 0; i < N; i++) {
			users.put(i + 1, new User(i + 1, weights[i]));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			User aUser = users.get(a);
			User bUser = users.get(b);

			// 둘은 친분 관계가 있다.
			aUser.addNeighbor(bUser);
			bUser.addNeighbor(aUser);
		}

		List<Integer> bestUsers = new ArrayList<>();
		for (User user : users.values()) {
			boolean isBest = true;
			for (User neighbor : user.neighbor) {
				if (user.weight <= neighbor.weight) {
					isBest = false;
					break;
				}
			}
			if (isBest) {
				bestUsers.add(user.no);
			}
		}

		// output
		bw.write(bestUsers.size() + "\n");

		bw.flush();
		bw.close();
	}
}
