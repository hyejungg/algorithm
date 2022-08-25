import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        // 일단 넣어
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        // 검사해
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) // 문자 하나씩 검사
                    return false;
            }
        }
        return true;
    }
}