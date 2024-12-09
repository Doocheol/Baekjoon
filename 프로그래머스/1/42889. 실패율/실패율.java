import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] stageCount = new int[N+2];
        for (int stage : stages) {
            stageCount[stage]++;
        }
        
        int players = stages.length;
        List<StageFailure> failures = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            if (players == 0) {
                failures.add(new StageFailure(i, 0.0));
                continue;
            }
            
            double failureRate = (double) stageCount[i] / players;
            failures.add(new StageFailure(i, failureRate));
            players -= stageCount[i];
        }
        
        Collections.sort(failures);
        
        // failures.sort((a, b) -> {
        //     if (b.failureRate != a.failureRate) {
        //         return Double.compare(b.failureRate, a.failureRate);
        //     }
        //     return Integer.compare(a.stage, b.stage);
        // });
            
            return failures.stream().mapToInt(f -> f.stage).toArray();
    
    }
    
    static class StageFailure implements Comparable<StageFailure> {
        int stage;
        double failureRate;
        
        public StageFailure(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
        
        @Override
        public int compareTo(StageFailure o) {
            if (o.failureRate != this.failureRate) {
                return Double.compare(o.failureRate, this.failureRate);
            }
            return Integer.compare(this.stage, o.stage);
            
        }
    }
}