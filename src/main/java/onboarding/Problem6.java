package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 두 글자 이상의 연속적인 문자 Map
        HashMap<String, Integer> map = new HashMap<>();
        // 두 글자 이상의 연속적인 문자 중복 유저 이메일 Set
        HashSet<String> set = new HashSet<>();

        // 두 글자 이상의 연속적인 문자가 중복되는 유저 이메일 추가
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String str = forms.get(i).get(1).substring(j, j + 2);
                if (map.containsKey(str)) {
                    set.add(forms.get(i).get(0));
                    set.add(forms.get(map.get(str)).get(0));
                } else {
                    map.put(str, i);
                }
            }
        }

        // set을 배열로 변환
        String[] arr = new String[set.size()];
        set.toArray(arr);
        // 변환한 배열을 오름차순 정렬
        Arrays.sort(arr);

        // 정렬한 배열을 리스트로 변환
        answer = Arrays.asList(arr);

        return answer;
    }
}
