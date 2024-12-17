import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        HashSet<String> usedWords = new HashSet<>();
        
        char prevWord = words[0].charAt(0);
        
        for (int i = 0; i < words.length; i++) {
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                return new int[]{(i%n + 1), (i/n + 1)};
            }
            usedWords.add(words[i]);
            prevWord = words[i].charAt(words[i].length()-1);
        }
        
        return new int[]{0, 0};
        
    }
}