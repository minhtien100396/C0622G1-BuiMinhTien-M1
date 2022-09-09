package case_study.task_1.utils.validate.input_customer;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.NameException;
import case_study.task_1.utils.exception.AddressException;

import java.util.Scanner;

public class InputAddressCustomerUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static final String ADDRESS_REGEX = "^[0-9A-Za-z vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ[/][,][-]]+$";

    public static String inputAddressCustomer() {
        String addressCustomer;
        while (true) {
            try {
                System.out.println("Mời bạn nhập địa chỉ của khách hàng (XX-XX-XX)");
                addressCustomer = scanner.nextLine();
                if (addressCustomer.matches(ADDRESS_REGEX)) {
                    break;
                } else {
                    throw new AddressException("Đỉa chỉ không hợp lệ!. Hãy kiểm tra lại(XX-XX-XX)");
                }
            } catch (AddressException e) {
                System.out.println(e.getMessage());
            }
        }

        return addressCustomer;
    }
}
