class Solution {
    public int[] solution(int n) {
        
        int[] arr = new int[(int) (n-1)/2];
        
        int num = 1;
        for (int i = 0; i < (n-1)/2; i++) {
            num++;
            if (num % 2 != 0) {
                arr[i] = num++;
            }
        }
        
        
        
        return arr;
    }
}