import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 전체 보석 종류의 개수를 구함
        int numUnique = new HashSet<>(Arrays.asList(gems)).size();
        
        // 슬라이딩 윈도우 내 보석 개수를 저장할 해시맵
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (right < gems.length) {
            // 오른쪽 포인터에 해당하는 보석 추가
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;
            
            // 현재 윈도우가 모든 보석 종류를 포함하면 왼쪽 포인터를 이동하여 구간 축소
            while (map.size() == numUnique) {
                // 현재 윈도우 길이가 최소 길이보다 작으면 정답 갱신
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1; // 문제에서 1-indexed로 요구함
                    answer[1] = right;
                }
                // 왼쪽 보석 제거 후, 개수가 0이면 해시맵에서 삭제
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
        }
        return answer;
    }
}
