class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        return sum;
    }
}