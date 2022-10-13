import java.util.*;

class Solution {
    class Streaming implements Comparable<Streaming>{
        int idx;
        String genres;
        int plays;

        public Streaming() {}

        public Streaming(int idx, String genres, int plays) {
            this.idx = idx;
            this.genres = genres;
            this.plays = plays;
        }

        @Override
        public int compareTo(Streaming s) {
            // 1. 많이 재생된 노래 먼저 정렬
            int comp1 = Integer.compare(s.plays, plays); //내림?
            // 2. 횟수가 같은 경우 낮은 노래 먼저 수록
            if (comp1 == 0) {
                return Integer.compare(plays, s.plays); //오름?
            }
            return comp1;
        }

        @Override
        public String toString() {
            return "idx = " + idx + ", genres = " + genres + ", plays = " + plays; 
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // int[] answer = {};
        Map<String, Integer> map = new HashMap<>(); // 장르별 재생 저장 횟수 저장
        ArrayList<Streaming> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            // 장르별 총 재생 횟수 저장
            if (map.containsKey(genres[i])) {
                int value = map.get(genres[i]);
                map.put(genres[i], value + plays[i]);
            }else{  
                map.put(genres[i], plays[i]);
            }
            list.add(new Streaming(i, genres[i], plays[i]));
        }

        // 1. 정렬 기준에 따라 먼저 정렬
        Collections.sort(list);

        // 2. value 값을 기준으로 map 내림차순 정렬
        List<String> mapKeySet = new ArrayList<>(map.keySet());
        mapKeySet.sort(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return map.get(key2).compareTo(map.get(key1));
            }
        });

        // 3. 장르별로 돌면서 최대 2개씩 베스트 앨범으로 뽑아
        ArrayList<Integer> answer = new ArrayList<>();
        for (String key : mapKeySet) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                if (cnt == 2) break;
                if (list.get(i).genres.equals(key)) {
                    answer.add(list.get(i).idx);
                    cnt++;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}