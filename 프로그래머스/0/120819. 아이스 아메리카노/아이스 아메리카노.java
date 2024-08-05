class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        
        int qty = money / 5500;
        int balance = money - qty * 5500;
        
        answer[0] = qty;
        answer[1] = balance;
        
        return answer;
    }
}