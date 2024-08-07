class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        String[] line = my_string.split("");
        
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(line[i]);
            }
        }
               
        return sb.toString();
    }
}