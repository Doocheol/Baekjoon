import java.util.*;          // 자바 유틸리티 패키지 임포트 (HashSet, etc.)
import java.util.regex.*;    // 자바 정규 표현식 패키지 임포트 (Pattern, Matcher)

class Solution {
    
    private static String[] userId;
    private static Pattern[] regex;
    private static boolean[] used;
    private static HashSet<String> answer;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        userId = user_id;
        used = new boolean[banned_id.length];
        regex = new Pattern[banned_id.length];
        
        for (int i = 0; i < banned_id.length; i++) {
            regex[i] = Pattern.compile(banned_id[i].replace("*", "[a-z0-9]"));
        }
        
        backtrack(0, "");
        
        return answer.size();
    }
    
   
    // 백트래킹 메서드
    private static void backtrack(int idx, String users) {
        // 현재까지 선택된 사용자 조합의 길이가 금지 패턴의 수와 같으면
        if (users.length() == regex.length) {
            // 현재 조합을 HashSet에 추가하여 고유성을 보장
            answer.add(users);
            // 더 이상 탐색할 필요가 없으므로 메서드 종료
            return;
        }

        // 현재 인덱스부터 사용자 ID 배열을 순회
        for (int i = idx; i < userId.length; i++) {
            String id = userId[i];  // 현재 사용자 ID

            // 모든 금지 패턴과 비교
            for (int j = 0; j < regex.length; j++) {
                // 해당 금지 패턴이 아직 사용되지 않았고, 현재 ID가 패턴과 일치하면
                if (!used[j] && regex[j].matcher(id).matches()) {
                    used[j] = true;                     // 해당 패턴을 사용된 것으로 표시
                    backtrack(i + 1, users + i);       // 다음 사용자 ID로 백트래킹
                    used[j] = false;                    // 패턴 사용 표시 해제 (백트랙)
                }
            }
        }
    }
}
