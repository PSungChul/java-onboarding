package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count = 1;
        int cnt = 3;

        // 각 자릿수 List
        List<Integer> list = new ArrayList<>();

        // 각 자릿수 구하기
        while (number != 0) {
            list.add(number % 10);
            number = number / 10;
        }

        // 3, 6, 9 박수 개수 구하기
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (3 <= list.get(i) && list.get(i) < 6) { // + 2
                    answer += count * 1;
                } else if (6 <= list.get(i) && list.get(i) < 9) { // + 3
                    answer += count * 2;
                } else if (list.get(i) == 9) {
                    answer += count * 3;
                }
            } else {
                cnt = (i * count * cnt) / 10;
                if (list.get(i) * count < 3 * count) {
                    answer += list.get(i) * cnt;
                } else if (list.get(i) * count == 3 * count) {
                    answer += list.get(i) * cnt + list.get(i-1) + 1;
                } else if (3 * count < list.get(i) * count && list.get(i) * count < 6 * count) {
                    answer += list.get(i) * cnt + count * 1;
                } else if (list.get(i) * count == 6 * count) {
                    answer += list.get(i) * cnt + list.get(i-1) + 1;
                } else if (6 * count < list.get(i) * count && list.get(i) * count < 9 * count) {
                    answer += list.get(i) * cnt + count * 2;
                } else if (list.get(i) * count == 9 * count) {
                    answer += list.get(i) * cnt + list.get(i-1) + 1;
                }
            }

            count *= 10;
            cnt = 3;
        }

        return answer;
    }
}
