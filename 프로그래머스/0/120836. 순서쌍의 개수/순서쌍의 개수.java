class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++; // (i, n/i)에서 i가 약수인 경우
                if (i != n / i) {
                    count++; // (n/i, i)에서 두 수가 다를 경우 추가
                }
            }
        }
        return count;
    }
}