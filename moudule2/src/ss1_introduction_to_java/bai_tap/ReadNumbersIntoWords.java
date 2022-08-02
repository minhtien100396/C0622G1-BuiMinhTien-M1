package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ReadNumbersIntoWords {
    public static void main(String[] args) {
        System.out.println("Nhập vào một số nguyên");
        Scanner scanner = new Scanner(System.in);
        int integer = Integer.parseInt(scanner.nextLine());
        int unitDigit = integer % 10;
        int tensDigit = integer % 100 - unitDigit;
        int hundredsDigit = integer % 1000 - tensDigit - unitDigit;
        String result = "";

        //Số nguyên < 0 và số nguyên >1000 thì nhập lại
        if (integer > 0 && integer < 1000) {

            if (hundredsDigit != 0) {
                switch (hundredsDigit) {
                    case 100: {
                        result += "Một trăm ";
                    }
                    break;
                    case 200: {
                        result += "Hai trăm ";
                    }
                    break;
                    case 300: {
                        result += "Ba trăm ";
                    }
                    break;
                    case 400: {
                        result += "Bốn trăm ";
                    }
                    break;
                    case 500: {
                        result += "Năm trăm ";
                    }
                    break;
                    case 600: {
                        result += "Sáu trăm ";
                    }
                    break;
                    case 700: {
                        result += "Bảy trăm ";
                    }
                    break;
                    case 800: {
                        result += "Tám trăm ";
                    }
                    break;
                    case 900: {
                        result += "Chín trăm ";
                    }
                    break;
                }
                switch (tensDigit) {
                    case 0:
                        if (unitDigit != 0) {
                            result += "linh ";
                        }
                        break;
                    case 10: {
                        result += "mười ";
                    }
                    break;
                    case 20: {
                        result += "hai mươi ";
                    }
                    break;
                    case 30: {
                        result += "ba mươi ";
                    }
                    break;
                    case 40: {
                        result += "bốn mươi ";
                    }
                    break;
                    case 50: {
                        result += "Năm mươi ";
                    }
                    break;
                    case 60: {
                        result += "sáu mươi ";
                    }
                    break;
                    case 70: {
                        result += "bảy mươi ";
                    }
                    break;
                    case 80: {
                        result += "tám mươi ";
                    }
                    break;
                    case 90: {
                        result += "chín mươi ";
                    }
                    break;
                }
                switch (unitDigit) {
                    case 1: {
                        if (tensDigit == 10) {
                            result += "một ";
                        } else {
                            result += "mốt ";
                        }
                    }
                    break;
                    case 2: {
                        result += "hai ";
                    }
                    break;
                    case 3: {
                        result += "ba ";
                    }
                    break;
                    case 4: {
                        result += "bốn ";
                    }
                    break;
                    case 5: {
                        if (tensDigit == 0) {
                            result += "năm ";
                        } else {
                            result += "lăm ";
                        }
                    }
                    break;
                    case 6: {
                        result += "sáu ";
                    }
                    break;
                    case 7: {
                        result += "bảy ";
                    }
                    break;
                    case 8: {
                        result += "tám ";
                    }
                    break;
                    case 9: {
                        result += "chín ";
                    }
                    break;
                }
            } else {
                switch (tensDigit) {
                    case 10: {
                        result += "Mười ";
                    }
                    break;
                    case 20: {
                        result += "Hai mươi ";
                    }
                    break;
                    case 30: {
                        result += "Ba mươi ";
                    }
                    break;
                    case 40: {
                        result += "Bốn mươi ";
                    }
                    break;
                    case 50: {
                        result += "Năm mươi ";
                    }
                    break;
                    case 60: {
                        result += "Sáu mươi ";
                    }
                    break;
                    case 70: {
                        result += "Bảy mươi ";
                    }
                    break;
                    case 80: {
                        result += "Tám mươi ";
                    }
                    break;
                    case 90: {
                        result += "Chín mươi ";
                    }
                    break;
                }

                switch (unitDigit) {
                    case 1: {
                        if ((tensDigit == 10) || (tensDigit == 0)) {
                            result += "một ";
                        } else {
                            result += "mốt ";
                        }
                    }
                    break;
                    case 2: {
                        result += "hai ";
                    }
                    break;
                    case 3: {
                        result += "ba ";
                    }
                    break;
                    case 4: {
                        result += "bốn ";
                    }
                    break;
                    case 5: {
                        if (tensDigit == 0) {
                            result += "Năm ";
                        } else {
                            result += "lăm ";
                        }
                    }
                    break;
                    case 6: {
                        result += "sáu ";
                    }
                    break;
                    case 7: {
                        result += "bảy ";
                    }
                    break;
                    case 8: {
                        result += "tám ";
                    }
                    break;
                    case 9: {
                        result += "chín ";
                    }
                    break;
                }
            }
            System.out.println(result);
        } else if (integer == 0) {
            result += "Không";
            System.out.println(result);
        } else {
            System.out.println("Vui lòng nhập lại.");
        }
    }
}

