import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 사용자 이름을 키로, 인덱스를 값으로 저장
        HashMap<String, Integer> idMap = new HashMap<>();
        int idx = 0;
        for (String s : id_list) {
            idMap.put(s, idx++);
        }

        // 각 사용자가 신고받은 횟수를 저장하는 맵
        HashMap<String, HashSet<String>> reportedMap = new HashMap<>();
        for (String s : report) {
            String[] info = s.split(" ");
            String reporter = info[0];
            String reported = info[1];

            // 신고당한 사람의 기록에 신고자를 추가
            reportedMap.putIfAbsent(reported, new HashSet<>());
            reportedMap.get(reported).add(reporter);
        }

        // 신고된 사용자 중 정지 조건을 만족하는 사용자 찾기
        int[] answer = new int[id_list.length];
        for (Map.Entry<String, HashSet<String>> entry : reportedMap.entrySet()) {
            HashSet<String> reporters = entry.getValue();
            if (reporters.size() >= k) { // 정지 조건
                for (String reporter : reporters) {
                    answer[idMap.get(reporter)]++; // 신고한 사용자에게 알림
                }
            }
        }

        return answer;
    }
}
