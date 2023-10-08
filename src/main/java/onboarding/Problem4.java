package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 청개구리 알파벳 Builder
        StringBuilder str = new StringBuilder();

        // 청개구리 알파벳 구하기
        for (int i = 0; i < word.length(); i++) {
            if (65 <= Integer.valueOf(word.charAt(i)) && Integer.valueOf(word.charAt(i)) <= 90) {
                str.append((char) (155 - Integer.valueOf(word.charAt(i))));
            } else if (97 <= Integer.valueOf(word.charAt(i)) && Integer.valueOf(word.charAt(i)) <= 122) {
                str.append((char) (219 - Integer.valueOf(word.charAt(i))));
            } else {
                str.append(" ");
            }
        }

        // Builder를 String으로 변환
        answer = str.toString();

        return answer;
    }
}
