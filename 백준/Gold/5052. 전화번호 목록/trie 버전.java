import java.util.*;
import java.lang.*;
import java.io.*;

// 트라이 버전
class Main {

    static class TrieNode {
        private Map<Character, TrieNode> childNode = new HashMap<>();
        private boolean isEnd; // 종료 노드 판단
    }

    static final TrieNode root = new TrieNode();

    static public void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.childNode.putIfAbsent(c, new TrieNode());
            current = current.childNode.get(c);
        }
        current.isEnd = true;
    }

    static public boolean isPrefixConflict(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.childNode.get(c);
            if (current == null) return false;
        }

        if (current.isEnd && !current.childNode.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            TrieNode root = new TrieNode();
            List<String> words = new ArrayList<>(); 
            
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words.add(word);
                insert(root, word);
            }

            boolean isInclude = true;
            for(String word : words) {
                if (isPrefixConflict(root, word)) {
                    isInclude = false;
                    break;
                }
            }
            
            if (isInclude == false) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
