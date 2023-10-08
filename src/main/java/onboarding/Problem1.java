package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 1;
        int c = 0;
        int d = 0;
        List<Integer> list = new ArrayList<>();

        if (pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1) {
            // pobi 페이지 번호
            for (int i = 0; i < pobi.size(); i++) {
                String str = String.valueOf(pobi.get(i));
                for (int j = 0; j < str.length(); j++) {
                    a += Character.getNumericValue(str.charAt(j));
                    b *= Character.getNumericValue(str.charAt(j));
                }
                if (i == 0) {
                    c = Math.max(a, b);
                } else {
                    d = Math.max(a, b);
                    list.add(0, Math.max(c, d));
                }
                a = 0;
                b = 1;
            }
            // crong 페이지 번호
            for (int i = 0; i < crong.size(); i++) {
                String str = String.valueOf(crong.get(i));
                for (int j = 0; j < str.length(); j++) {
                    a += Character.getNumericValue(str.charAt(j));
                    b *= Character.getNumericValue(str.charAt(j));
                }
                if (i == 0) {
                    c = Math.max(a, b);
                } else {
                    d = Math.max(a, b);
                    list.add(1, Math.max(c, d));
                }
                a = 0;
                b = 1;
            }
            // pobi와 crong 페이지 번호 비교
            if (list.get(0) == list.get(1)) {
                answer = 0;
            } else {
                if (list.get(0) > list.get(1)) {
                    answer = 1;
                } else {
                    answer = 2;
                }
            }
        } else {
            answer = -1;
        }

        return answer;
    }
}