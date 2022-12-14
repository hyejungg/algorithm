import java.util.*;
import java.util.stream.*; // Collectors 사용하려면 필요

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toSet());
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (set.contains(phone_book[i].substring(0, j)))
                    return false;
            }
        }
        
        return true;
    }
}