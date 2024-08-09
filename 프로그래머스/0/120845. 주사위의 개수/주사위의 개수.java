class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        
        int dice = 1;
        for (int i = 0; i < box.length; i++) {
            box[i] = box[i] / n;
            dice *= box[i];
        }
        
        answer = dice;
        return answer;
    }
}