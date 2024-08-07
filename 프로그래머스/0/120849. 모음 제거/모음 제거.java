class Solution {
    public String solution(String my_string) {
        String answer = my_string;
        String[] moeum = {"a", "e", "i", "o", "u"};
        for (int i = 0; i < moeum.length; i++) {
            answer = answer.replaceAll(moeum[i], "");
        }
        
        
        return answer;
    }
}