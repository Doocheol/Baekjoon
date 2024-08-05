class Solution {
    public int solution(int n, int k) {

        int answer =  0;

        if (n>=10) {
            k = k - (n/10);
            answer = 12000*n + 2000*k;
        } else {
            answer = 12000*n + 2000*k;
        }
        return answer;
    }
}