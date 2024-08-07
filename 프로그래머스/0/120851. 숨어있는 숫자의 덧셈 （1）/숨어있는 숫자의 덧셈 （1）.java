import java.util.*;
import java.io.*;

class Solution {
    public int solution(String my_string) {
        char c;
        int num;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            
            c = my_string.charAt(i);
            
            if ('0' <= c && c <= '9') {
                list.add(c - '0');
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        
        int answer = sum;
        return answer;
    }
}