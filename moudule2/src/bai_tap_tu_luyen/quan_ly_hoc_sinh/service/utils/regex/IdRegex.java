package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.regex;

import java.util.regex.Pattern;

public class IdRegex {
    private  static final String ID_REGEX = "^MSHV[0-9]+$";

    public static void idRegex() {
        Pattern pattern = Pattern.compile(ID_REGEX);
    }
}
