import java.util.*;

class Solution {
    class GameInfo implements Comparable<GameInfo> {
        int idx;
        int pay;
        int date;
        int discountPersent;
        int discountPay;

        public GameInfo(){}
        public GameInfo(int idx, int pay, int date, int discountPersent) {
            this.idx = idx;
            this.pay = pay;
            this.date = date;
            this.discountPersent = discountPersent;
            this.discountPay = culculateDiscountPay(pay, discountPersent);
        }

        private int culculateDiscountPay(int pay, int persent) {
            double money = (double) pay * ((double) (100 - persent) / 100);
            return (int) money;
        }

        public int getDiscountPersent() {
            return this.discountPersent;
        }

        @Override
        public int compareTo(GameInfo g) {
            int comp1 = Integer.compare(date, g.date);
            if (comp1 == 0)
                return Integer.compare(discountPersent, g.discountPersent);
            return comp1;
        }

        @Override
        public String toString() {
            return "idx: " + idx + ", pay: " + pay + ", date: " + date + ", discountPersent: " + discountPersent
                    + ", discountPay: " + discountPay;
        }
    }
    public int solution(int[][] games) {
        Map<Integer, Integer> map = new HashMap<>();

        List<GameInfo> gamesInfo = new ArrayList<>();
        for (int i = 0; i < games.length; i++) {
            if(map.containsKey(games[i][1])) {
                int value = map.get(games[i][1]) + 1;
                map.put(games[i][1], value);
            } else {
                map.put(games[i][1], 1);
            }

            gamesInfo.add(new GameInfo(i + 1, games[i][0], games[i][1], games[i][2]));
        }

        Collections.sort(gamesInfo);

        int answer = 0;

        if (map.size() == 1) {
            for (GameInfo game : gamesInfo) {
                answer += game.discountPay;
            }
            return answer;
        }
        // map.size() != 1 ??????
        // map??? ????????? value??? 1?????? discountPay??? ?????????
        // value??? 1??? ?????????
        // gamesInfo?????? date??? ?????? ?????? filter ????????? discountPersent ????????? ?????????
        // discountPersent ??? ??? ?????? ?????? ??????(pay)??? ??????

        // for (Integer key : map.keySet()) {
        //     if (map.get(key) == 1) {
        //         answer += discountPay;
        //     } else {
        //         List<GameInfo> list = gamesInfo.stream().filter(game -> game.date == key)
        //             .sort(Comparator.comparing(GameInfo::getDiscountPersent).collect(toList()));
        //     }
        // }

        for (int day = 0; day < gamesInfo.size(); day++) {
            GameInfo now = gamesInfo.get(day);
            if (day == now.date) { // ???????????? ?????????
                answer += now.discountPay;
                continue;
            }
            answer += now.pay; // ????????? ?????????
        }

        return answer;
    }
}
