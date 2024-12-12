import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<String, String> map = new HashMap<>();
        
        int count = 0;
        for (String s : record) {
            
            String[] text = s.split(" ");
            
            if (text[0].equals("Enter") || text[0].equals("Leave")) count++;
            
            if (text[0].equals("Enter") || text[0].equals("Change")) {
                map.put(text[1], text[2]);
            }
            
        }
        String[] answer = new String[count];
        
        int idx = 0;
        for (String s : record) {
            
            String[] text = s.split(" ");
            if (text[0].equals("Enter")) {
                answer[idx++] = map.get(text[1]) + "님이 들어왔습니다.";
            }
            else if (text[0].equals("Leave")) {
                answer[idx++] = map.get(text[1]) + "님이 나갔습니다.";
            }
            
        }
        
        return answer;
    }
}