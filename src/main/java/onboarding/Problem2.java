package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        // 파라미터로 받아온 String을 Builder로 변환
        StringBuilder str = new StringBuilder(cryptogram);
        // 조건 체크값
        boolean check = true;

        // 연속 중복 단어 제거
        while (check) {
            check = false;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) == str.charAt(i)) {
                    str.deleteCharAt(i);
                    str.deleteCharAt(i - 1);
                    check = true;
                }
            }
        }

        // Builder를 String으로 변환
        answer = str.toString();

        return answer;
    }
}
