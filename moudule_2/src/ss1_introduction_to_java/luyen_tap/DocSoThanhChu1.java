package ss1_introduction_to_java.luyen_tap;

import java.util.Scanner;

public class DocSoThanhChu1 {
    public static void main(String[] args) {
        System.out.println("Nhập vào một số nguyên");
        int soNguyen = new Scanner(System.in).nextInt();
        int donVi = soNguyen % 10;
        int hangChuc = soNguyen % 100 - donVi;
        int hangTram = soNguyen % 1000 - hangChuc - donVi;
        String ketQua = "";
        if (soNguyen >= 0 && soNguyen < 1000) {
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
                if (hangChuc != 0 && hangChuc != 10) {
                    switch (hangChuc) {
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
                    if (donVi != 0) {
                        switch (donVi) {
                            case 1: {
                                ketQua += "mốt ";
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
                                ketQua += "lăm ";
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
                }
                if (hangChuc == 0) {
                    if (donVi != 0) {
                        ketQua += "linh ";
                        switch (donVi) {
                            case 1: {
                                ketQua += "mốt ";
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
                                ketQua += "năm ";
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
                }
                if (hangChuc == 10) {
                    if (donVi != 0) {
                        ketQua += "mười ";
                        switch (donVi) {
                            case 1: {
                                ketQua += "một ";
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
                                ketQua += "lăm ";
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
                }
            } else {
                if (hangChuc != 0 && hangChuc != 10) {
                    switch (hangChuc) {
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
                    if (donVi != 0) {
                        switch (donVi) {
                            case 1: {
                                ketQua += "mốt ";
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
                                ketQua += "lăm ";
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
                }
                if (hangChuc == 0) {
                    switch (donVi) {
                        case 0: {
                            ketQua += "Không ";
                        }
                        break;
                        case 1: {
                            ketQua += "Một ";
                        }
                        break;
                        case 2: {
                            ketQua += "Hai ";
                        }
                        break;
                        case 3: {
                            ketQua += "Ba ";
                        }
                        break;
                        case 4: {
                            ketQua += "Bốn ";
                        }
                        break;
                        case 5: {
                            ketQua += "Năm ";
                        }
                        break;
                        case 6: {
                            ketQua += "Sáu ";
                        }
                        break;
                        case 7: {
                            ketQua += "Bảy ";
                        }
                        break;
                        case 8: {
                            ketQua += "Tám ";
                        }
                        break;
                        case 9: {
                            ketQua += "Chín ";
                        }
                        break;
                    }
                }

                if (hangChuc == 10) {
                    ketQua += "mười ";
                    switch (donVi) {
                        case 0: {
                            ketQua += "";
                        }
                        break;
                        case 1: {
                            ketQua += "một ";
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
                            ketQua += "lăm ";
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
            }
            System.out.println(ketQua);
        } else {
            System.out.println("Vui lòng nhập lại.");
        }
    }
}

