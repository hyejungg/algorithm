import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";

			// 삭제된 주문 배열을 숫자로 변환
			long[] bansNums = new long[bans.length];
			for(int i=0; i<bans.length; i++) {
				bansNums[i] = convertStrToNum(bans[i]);
			}

			Arrays.sort(bansNums);

			// n 보다 작거나 같은 삭제된 문자는 +해서 주문 찾기
			for(long bn : bansNums) {
				if(bn <= n) {
					n++;
				}
			}

			answer = convertNumToStr(n);

			return answer;
		}

		private long convertStrToNum(String str) {
			long num = 0;

			for(int j=0;j<str.length();j++) {
				// a=1, b=2, c=3, ..., z=26
				// 26진법을 위해 * 26
				num += (long)((str.charAt(j)-96) * Math.pow(26,(str.length()-1-j)));
			}

			return num;
		}
		private String convertNumToStr(long num) {
			StringBuilder str = new StringBuilder();

			while(num > 0) {
				str.insert(0, String.valueOf((char)((num - 1) % 26 + 1 + 96)));
				num=(num-1)/26;
			}

			return str.toString();
		}
	}