import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            if (map.getOrDefault(name, 0) == 0) {
                return name;
            }
            map.put(name, map.get(name) - 1);
        }
        return null;

    }
}