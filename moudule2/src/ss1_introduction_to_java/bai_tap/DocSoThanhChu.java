package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        System.out.println("Nhập vào một số nguyên");
        int soNguyen = new Scanner(System.in).nextInt();
        int donVi = soNguyen % 10;
        int hangChuc = soNguyen % 100 - donVi;
        int hangTram = soNguyen % 1000 - hangChuc - donVi;
        String ketQua = "";

        //Số nguyên < 0 và số nguyên >1000 thì nhập lại
        if (soNguyen > 0 && soNguyen < 1000) {

            if (hangTram != 0) {
                switch (hangTram) {
                    case 100: {
                        ketQua += "Một trăm ";
                    }
                    break;
                    case 200: {
                        ketQua += "Hai trăm ";
                    }
                    break;
                    case 300: {
                        ketQua += "Ba trăm ";
                    }
                    break;
                    case 400: {
                        ketQua += "Bốn trăm ";
                    }
                    break;
                    case 500: {
                        ketQua += "Năm trăm ";
                    }
                    break;
                    case 600: {
                        ketQua += "Sáu trăm ";
                    }
                    break;
                    case 700: {
                        ketQua += "Bảy trăm ";
                    }
                    break;
                    case 800: {
                        ketQua += "Tám trăm ";
                    }
                    break;
                    case 900: {
                        ketQua += "Chín trăm ";
                    }
                    break;
                }
                switch (hangChuc) {
                    case 0:
                        if (donVi != 0) {
                            ketQua += "linh ";
                        }
                        break;
                    case 10: {
                        ketQua += "mười ";
                    }
                    break;
                    case 20: {
                        ketQua += "hai mươi ";
                    }
                    break;
                    case 30: {
                        ketQua += "ba mươi ";
                    }
                    break;
                    case 40: {
                        ketQua += "bốn mươi ";
                    }
                    break;
                    case 50: {
                        ketQua += "Năm mươi ";
                    }
                    break;
                    case 60: {
                        ketQua += "sáu mươi ";
                    }
                    break;
                    case 70: {
                        ketQua += "bảy mươi ";
                    }
                    break;
                    case 80: {
                        ketQua += "tám mươi ";
                    }
                    break;
                    case 90: {
                        ketQua += "chín mươi ";
                    }
                    break;
                }
                switch (donVi) {
                    case 1: {
                        if (hangChuc == 10) {
                            ketQua += "một ";
                        } else {
                            ketQua += "mốt ";
                        }
                    }
                    break;
                    case 2: {
                        ketQua += "hai ";
                    }
                    break;
                    case 3: {
                        ketQua += "ba ";
                    }
                    break;
                    case 4: {
                        ketQua += "bốn ";
                    }
                    break;
                    case 5: {
                        if (hangChuc == 0) {
                            ketQua += "năm ";
                        } else {
                            ketQua += "lăm ";
                        }
                    }
                    break;
                    case 6: {
                        ketQua += "sáu ";
                    }
                    break;
                    case 7: {
                        ketQua += "bảy ";
                    }
                    break;
                    case 8: {
                        ketQua += "tám ";
                    }
                    break;
                    case 9: {
                        ketQua += "chín ";
                    }
                    break;
                }
            } else {
                switch (hangChuc) {
                    case 10: {
                        ketQua += "Mười ";
                    }
                    break;
                    case 20: {
                        ketQua += "Hai mươi ";
                    }
                    break;
                    case 30: {
                        ketQua += "Ba mươi ";
                    }
                    break;
                    case 40: {
                        ketQua += "Bốn mươi ";
                    }
                    break;
                    case 50: {
                        ketQua += "Năm mươi ";
                    }
                    break;
                    case 60: {
                        ketQua += "Sáu mươi ";
                    }
                    break;
                    case 70: {
                        ketQua += "Bảy mươi ";
                    }
                    break;
                    case 80: {
                        ketQua += "Tám mươi ";
                    }
                    break;
                    case 90: {
                        ketQua += "Chín mươi ";
                    }
                    break;
                }

                switch (donVi) {
                    case 1: {
                        if ((hangChuc == 10) || (hangChuc == 0)) {
                            ketQua += "một ";
                        } else {
                            ketQua += "mốt ";
                        }
                    }
                    break;
                    case 2: {
                        ketQua += "hai ";
                    }
                    break;
                    case 3: {
                        ketQua += "ba ";
                    }
                    break;
                    case 4: {
                        ketQua += "bốn ";
                    }
                    break;
                    case 5: {
                        if (hangChuc == 0) {
                            ketQua += "Năm ";
                        } else {
                            ketQua += "lăm ";
                        }
                    }
                    break;
                    case 6: {
                        ketQua += "sáu ";
                    }
                    break;
                    case 7: {
                        ketQua += "bảy ";
                    }
                    break;
                    case 8: {
                        ketQua += "tám ";
                    }
                    break;
                    case 9: {
                        ketQua += "chín ";
                    }
                    break;
                }
            }
            System.out.println(ketQua);
        } else if (soNguyen == 0) {
            ketQua += "Không";
            System.out.println(ketQua);
        } else {
            System.out.println("Vui lòng nhập lại.");
        }
    }
}

