class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        answer = array[(array.length - 1) / 2];
        
        return answer;
    }
}