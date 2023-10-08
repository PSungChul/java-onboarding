package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        // 키에 대한 오름차순 Map
        TreeMap<String, Integer> map = new TreeMap<>();
        // 제외해야 할 친구 Map
        HashMap<String, Integer> cancel = new HashMap<>();

        // 사용자와 함께 아는 친구 + 10
        for (int i = 0; i < friends.size(); i++) {
            if (!friends.get(i).get(1).equals(user)) {
                if (map.containsKey(friends.get(i).get(1))) {
                    map.put(friends.get(i).get(1), map.get(friends.get(i).get(1)) + 10);
                    if (!cancel.containsKey(friends.get(i).get(0))) {
                        cancel.put(friends.get(i).get(0), -1);
                    }
                } else {
                    map.put(friends.get(i).get(1), 10);
                    if (!cancel.containsKey(friends.get(i).get(0))) {
                        cancel.put(friends.get(i).get(0), -1);
                    }
                }
            }
        }

        // 사용자의 타임 라인에 방문자 + 1점
        for (int i = 0; i < visitors.size(); i++) {
            if (!visitors.get(i).equals(user) && !cancel.containsKey(visitors.get(i))) {
                if (map.containsKey(visitors.get(i))) {
                    map.put(visitors.get(i), map.get(visitors.get(i)) + 1);
                } else {
                    map.put(visitors.get(i), 1);
                }
            }
        }

        // 키, 값 배열로 변환
        Entry<String, Integer>[] entries = map.entrySet().toArray(new Entry[0]);
        // 값에 대한 내림차순
        Arrays.sort(entries, Comparator.comparing(Entry::getValue, Comparator.reverseOrder()));

        // 점수에 대한 내림차순 및 이름에 대한 오름차순으로 결과 생성
        for (Entry<String, Integer> entry : entries) {
            answer.add(entry.getKey());
            if (answer.size() == 5) {
                break;
            }
        }

        return answer;
    }
}