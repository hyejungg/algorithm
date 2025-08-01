package lv3_GINI야_도와줘;

import java.io.*;
import java.util.*;

/**
 * https://softeer.ai/practice/6271
 *
 * 최단 경로 문제 == BFS
 */

public class Main {

	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int r, c;
	static char[][] map;
	static int[][] rain_time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		rain_time = new int[r][c];

		Node start = new Node(0, 0);
		Node end = new Node(0, 0);
		ArrayList<Node> rain_first = new ArrayList<>();
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				switch(map[i][j]) {
					case 'W' :
						start.x = i;
						start.y = j;
						map[i][j] = '.';
						break;
					case 'H' :
						end.x = i;
						end.y = j;
						break;
					case '*' :
						rain_first.add(new Node(i, j));
						break;
				}
			}
		}

		rain(rain_first);
		move(start, end);
	}

	// 각 위치에서 소나기가 내리기 시작하는 시간 구하기
	public static void rain(ArrayList<Node> rain_first) {
		Queue<Node> queue = new LinkedList<>();
		for(Node n : rain_first) {
			rain_time[n.x][n.y] = 1;
			queue.add(n);
		}

		while(!queue.isEmpty()) {
			Node current = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = current.x + dir[i][0];
				int ny = current.y + dir[i][1];

				if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
					continue;
				}

				if(rain_time[nx][ny] == 0 && map[nx][ny] == '.') {
					rain_time[nx][ny] = rain_time[current.x][current.y] + 1;
					queue.add(new Node(nx, ny));
				}
			}
		}
	}

	// 비를 피해 차로 이동하는 시간 구하기
	public static void move(Node start, Node end) {
		int[][] count = new int[r][c];
		Queue<Node> queue = new LinkedList<>();

		count[start.x][start.y] = 1;
		queue.add(start);

		while(!queue.isEmpty()) {
			Node current = queue.poll();

			for(int i = 0; i < 4; i++) {
				int nx = current.x + dir[i][0];
				int ny = current.y + dir[i][1];

				if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
					continue;
				}

				if(count[nx][ny] > 0 || map[nx][ny] == 'X' || map[nx][ny] == '*') {
					continue;
				}

				if(count[current.x][current.y] + 1 < rain_time[nx][ny] || rain_time[nx][ny] == 0) {
					count[nx][ny] = count[current.x][current.y] + 1;
					queue.add(new Node(nx, ny));
				}
			}
		}

		if(count[end.x][end.y] == 0) {
			System.out.println("FAIL");
		}
		else {
			System.out.println(count[end.x][end.y]-1);
		}
	}
}
