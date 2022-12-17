import java.util.*;

class Solution {
    private static final String DOWN = "DOWN";
    private static final String UP = "UP";
    private static final String NONE = "NONE";

    class UserInfo {
        int registerMonth;
        int payMoneysThisMonth;
        int payMoneysNextMonth;
        boolean isVipThisMonth;
        boolean isVipNextMonth;

        public UserInfo() {}
        public UserInfo(int registerMonth, int payMoneysThisMonth, int payMoneysNextMonth, boolean isVipThisMonth, boolean isVipNextMonth) {
            this.registerMonth = registerMonth;
            this.payMoneysThisMonth = payMoneysThisMonth;
            this.payMoneysNextMonth = payMoneysNextMonth;
            this.isVipThisMonth = isVipThisMonth;
            this.isVipNextMonth = isVipNextMonth;
        }

        @Override
        public String toString() {
            return "registerMonth: " + registerMonth + ", payMoneysThisMonth: " + payMoneysThisMonth
                    + ", payMoneysNextMonth: " + payMoneysNextMonth + ", isVipThisMonth: " + isVipThisMonth
                    + ", isVipNextMonth: " + isVipNextMonth;
        }
    }
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];

        Map<String, Integer> map = new HashMap();
        map.put(UP, 0);
        map.put(DOWN, 0);

        List<UserInfo> users = new ArrayList<>();
        for (int i = 0; i < payments.length; i++) {
            int sumThisMonth = Arrays.stream(payments[i]).sum(); // 납부 합계
            int sumNextMonth = (sumThisMonth - payments[i][0]) + estimates[i];
            boolean nowScore = isVip(periods[i], sumThisMonth);
            boolean nextScore = isVip(periods[i] + 1, sumNextMonth);
            users.add(new UserInfo(periods[i], sumThisMonth, sumNextMonth, nowScore, nextScore));
        }

        for (UserInfo user : users) {
            String nowScore = getScoreUpAndDown(user);
            if (nowScore == UP) {
                map.put(UP, map.get(UP) + 1);
            }

            if (nowScore == DOWN) {
                map.put(DOWN, map.get(DOWN) + 1);
            }
        }

        answer[0] = map.get(UP);
        answer[1] = map.get(DOWN);

        return answer;
    }

    public String getScoreUpAndDown(UserInfo user) {
        if (user.isVipThisMonth && !user.isVipNextMonth) {
            return DOWN;
        }
        if (!user.isVipThisMonth && user.isVipNextMonth) {
            return UP;
        }
        return NONE;
    }

    public boolean isVip(int totalRegisterMonth, int totalPayMoneys) {
        if (totalRegisterMonth >= 24 && totalPayMoneys >= 900000) {
            return true;
        }
        if (totalRegisterMonth >= 60 && (totalPayMoneys >= 600000 && totalPayMoneys <= 900000)) {
            return true;
        }
        return false;
    }

}
