class Solution {
    public int solution(int n, int t) {
        int answer = 0;
        
        answer = n * power(n, t);
        
        return answer;
    }
    
    private static int power(int n, int t) {
        if (t == 0) {
            return 1;
        }
        
        return 2 * power(n, t-1);
    }
}