package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX_EMAIL = "^[([A-Za-z]+)([0-9]*)]{5,30}@[a-z]+(\\.[a-z]+)$";
    private static final String REGEX_NAME = "^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,50}$";
    private static final String REGEX_COUNTRY = "^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,50}$";


    public  static boolean regexEmail(String email) {
        // pattern : truyền vào regex
        //matcher : truyền vào chuỗi cần kiểm tra với regex
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(email);
        if (!matcher.find()){
            return true;
        }
        return false;
    }

    public  static boolean regexName(String name) {
        pattern = Pattern.compile(REGEX_NAME);
        matcher = pattern.matcher(name);
        if (!matcher.find()){
            return true;
        }
        return false;
    }

    public  static boolean regexCountry(String country) {
        pattern = Pattern.compile(REGEX_COUNTRY);
        matcher = pattern.matcher(country);
        if (!matcher.find()){
            return true;
        }
        return false;
    }
}
