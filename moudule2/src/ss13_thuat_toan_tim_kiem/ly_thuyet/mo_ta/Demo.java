package ss13_thuat_toan_tim_kiem.ly_thuyet.mo_ta;

public class Demo {
    public static void main(String[] args) {
        System.out.println(solution("CodegymStudy"));
    }

    public static String solution(String str) {
        String ketQua = "";
        for (int i = 0; i < str.length(); i++) {
            String word = str.charAt(i) + "";
            if(word.equals(word.toUpperCase())){
                ketQua+=(" "+word.toLowerCase());
            }else {
                ketQua+=word;
            }
        }
        return ketQua.trim();
    }
}
