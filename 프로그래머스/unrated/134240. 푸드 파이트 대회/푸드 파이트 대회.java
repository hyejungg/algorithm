import java.util.*;

class Solution {
    // public String solution(int[] food) {
    //     StringBuilder a1 = new StringBuilder();
    //     int number = 1;
    //     for (int i = 1; i < food.length; i++) {
    //         StringBuilder str = new StringBuilder();
    //         int count = 0;
    //         while (count < food[i] / 2) {
    //             str.append(number);
    //             count++;
    //         }
    //         a1.append(str);
    //         number++;
    //     }
    //     String a1String = a1.toString();
    //     StringBuilder a2 = a1.reverse();
    //     a2.insert(0, "0");
    //     return a1String.concat(a2.toString());
    // }
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            /**
              * String 에 repeat 내장 함수 : 주어진 횟수만큼 반복
              * i.repeat(n) 이면 i를 n만큼 붙여서 string으로 만듬
              */
            sb.append(Integer.toString(i).repeat(food[i] / 2));
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }
}