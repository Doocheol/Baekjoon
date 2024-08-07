import java.util.*;
import java.io.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < my_string.length(); i++) {
            c = my_string.charAt(i);
            if ('a' <= c && c <= 'z') {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

        }
        
        return sb.toString();
    }
}