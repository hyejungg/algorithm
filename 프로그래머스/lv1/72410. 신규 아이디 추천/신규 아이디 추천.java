import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계 대문자 -> 소문자로 변환
        String answer = new_id.toLowerCase();
        
        // 2단계 소문자, 숫자, -, _, . 제외 모두 제거
        answer = answer.replaceAll("[^a-z\\d\\-_.]", "");
        
        // 3단계 . 연속 시 1개의 .으로 치환
        answer = answer.replaceAll("\\.{2,}", "."); //.이 최소 2개 이상 반복
        
        // 4단계 .가 처음 또는 마지막에 있다면 제거
        answer = answer.replaceAll("^[.]|[.]$", ""); // [] 1개의 문자만 
        
        // 5단계 빈 문자열이면 a를 대입
        if (answer.length() == 0) answer = "a";
        
        // 6단계 16자 이상 -> 15개를 제외한 모두 제거
        if (answer.length() >= 16) answer = answer.substring(0, 15);
        
        if (answer.charAt(answer.length() - 1) == '.') answer = answer.replaceAll("[.]$", "");
        
        // 7단계 2자 이하라면 3이 될 때까지 마지막 문자를 반복해서 붙임
        if (answer.length() <= 2) {
            Character lastChar = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += lastChar;
            }
        }
        
        return answer;
    }
}