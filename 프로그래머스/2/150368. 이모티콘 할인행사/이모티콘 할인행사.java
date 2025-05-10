import java.util.*;

class Solution {
    static class Emoticon {
        int originalPrice;
        int discountRate;
        int discountedPrice;
        
        Emoticon(int originalPrice) {
            this.originalPrice = originalPrice;
            this.discountRate = 0;
            this.discountedPrice = originalPrice;
        }
        
        void applyDiscount(int rate) {
            this.discountRate = rate;
            this.discountedPrice = this.originalPrice * (100 - rate) / 100;
        }
    }
    
    static class User {
        int minDiscountRate;
        int maxTotal;
        
        User(int minDiscountRate, int maxTotal) {
            this.minDiscountRate = minDiscountRate;
            this.maxTotal = maxTotal;
        }
        
        boolean willSubscribe(int total) {
            return total >= this.maxTotal;
        }
    }
    
    int maxSubscribers = 0;
    int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        List<User> userList = new ArrayList<>();
        for (int[] u : users) {
            userList.add(new User(u[0], u[1]));
        }
        
        List<Emoticon> emoticonList = new ArrayList<>();
        for (int price : emoticons) {
            emoticonList.add(new Emoticon(price));
        }
        
        // 이모티콘 할인율 별로 할인 가격 계산
        dfs(0, emoticonList, userList);
        
        // 최대 구독자 및 할인 금액 계산
        return new int[]{maxSubscribers, maxSales};
    }
    
    private void dfs(int depth, List<Emoticon> emoticonList, List<User> users) {
        if (depth == emoticonList.size()) {
            culc(emoticonList, users);
            return;
        }
        
        int[] discountRates = {10, 20, 30, 40}; // 고정
        for (int rate : discountRates) {
            emoticonList.get(depth).applyDiscount(rate);
            dfs(depth + 1, emoticonList, users);
        }
    }
    
    private int[] culc(List<Emoticon> emoticonList, List<User> users) { 
        int totalSubscribers = 0;
        int totalSales = 0;
        
        for (User user : users) {
            int total = 0;
            
            for (Emoticon e : emoticonList) {
                if (e.discountRate >= user.minDiscountRate) {
                    total += e.discountedPrice;
                }
            }
            
            if (user.willSubscribe(total)) {
                totalSubscribers++;
            } else {
                totalSales += total;
            }
        }
        
        if (totalSubscribers > maxSubscribers) {
            maxSubscribers = totalSubscribers;
            maxSales = totalSales;
        } else if (totalSubscribers == maxSubscribers) {
            maxSales = Math.max(maxSales, totalSales);
        }
        
        return new int[]{totalSubscribers, totalSales};
    }
}