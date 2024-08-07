class Solution {
    public int solution(int hp) {
        
        int boss = 5;
        int normal = 3;
        int work = 1;
        
        int temp1 = hp / boss;
        int temp2 = (hp % boss) / normal;
        int temp3 = ((hp % boss) % normal) / work;
        
        int answer = temp1 + temp2 + temp3;
        return answer;
    }
}