class Solution {
    public int[] solution(int n) {
        
        int[] arr;
        if (n % 2 == 0) {
            arr = new int[n / 2];
        } else {
            arr = new int [(n+1)/2];
        }
        
        int idx = 0;
        for (int i = 1; i <= arr.length; i++) {
            arr[idx++] = i * 2 - 1;
        }
        
        return arr;
    }
}