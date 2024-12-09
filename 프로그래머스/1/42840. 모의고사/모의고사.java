import java.util.*;
import java.io.*;

class Solution {
       public int[] solution(int[] answers) {
           
           int[][] pattern = {
               {1, 2, 3, 4, 5},
               {2, 1, 2, 3, 2, 4, 2, 5},
               {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
           };
           
           int[] scores = new int[3];
           
           for (int i = 0; i < answers.length; i++) {
               for (int j = 0; j < pattern.length; j++) {
                   if (answers[i] == pattern[j][i % pattern[j].length]) {
                       scores[j]++;
                   }
               }
           }
           
           int maxScore = Arrays.stream(scores).max().getAsInt();
           
           ArrayList<Integer> answer = new ArrayList<>();
           
           for (int i = 0; i < scores.length; i++) {
               if (scores[i] == maxScore) {
                   answer.add(i + 1);
               }
           }
           
           return answer.stream().mapToInt(Integer::intValue).toArray();
           
//            int[] first = {1,2,3,4,5}; // 2000
//            int[] second = {2,1,2,3,2,4,2,5}; // 1250
//            int[] third = {3,3,1,1,2,2,4,4,5,5}; // 1000
        
           
           
//            int firstCount = 0;
//            int secondCount = 0;
//            int thirdCount = 0;
           
//            for (int i = 0; i < first.length; i++) {
//                if (first[i] == answers[i]) firstCount++;
//            }
           
//            for (int i = 0; i < 40; i++) {
//                if (second[i%second.length] == answers[i%answers.length]) secondCount++;
//            }
           
//            for (int i = 0; i < third.length; i++) {
//                if (third[i] == answers[i%answers.length]) thirdCount++;
//            }
           
//            firstCount *= 2000;
//            secondCount *= 250;
//            thirdCount *= 1000;
           
//             ArrayList<Integer> list = new ArrayList<>();
           
//            if (firstCount >= secondCount && firstCount >= thirdCount) {
//                list.add(1);
//            } else if (secondCount >= firstCount && secondCount >= thirdCount) {
//                list.add(2);
//            } else if (thirdCount >= firstCount && thirdCount >= secondCount) {
//                list.add(3);
//            }
           
               
//            return list.stream().sorted().mapToInt(Integer::intValue).toArray();
        
    }
}