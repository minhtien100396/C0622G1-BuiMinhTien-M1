package ss18_string_and_regex.luyen_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoParttern {
    private static final String ACCOUNT_REGEX = "^[0-9a-zA-Z]{5,}$";

    public static void main(String[] args) {
        //Pattern để biên dịch từ cái chuỗi ACCOUNT_REGEX
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher("aa122aAAAA");
        //Matcher :  xem chuỗi nhập vào  có khớp với ACCOINT_REGEX hay không
        //matches() : trả về true nếu khớp, false: nếu không khớp
        System.out.println(matcher.matches());
    }
}
