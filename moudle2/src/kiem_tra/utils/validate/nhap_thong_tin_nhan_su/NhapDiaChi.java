package kiem_tra.utils.validate.nhap_thong_tin_nhan_su;

import case_study.task_1.utils.exception.AddressException;

import java.util.Scanner;

public class NhapDiaChi {
    private static Scanner scanner = new Scanner(System.in);
    private static final String ADDRESS_REGEX = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ ]{5,50}$";

    public static String nhapDiaChi() {
        String addressCustomer;
        while (true) {
            try {
                System.out.println("Mời bạn nhập địa chỉ của Nhân Sự (XX-XX-XX)");
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
