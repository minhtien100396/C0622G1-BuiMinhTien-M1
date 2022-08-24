package case_study.task_1.controllers;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Hãy nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 6) {
                System.out.println("Hãy nhập lựa chọn có trong MENU");
            } else {
                switch (choice) {
                    case 1:
                        while (true) {
                            System.out.println("------------------------------------");
                            System.out.println("MENU EMPLOYEE MANAGEMENT ");
                            System.out.println("1. Display list employees");
                            System.out.println("2. Add new employee");
                            System.out.println("3. Edit employee");
                            System.out.println("4. Return main menu");
                            System.out.println("Hãy nhập lựa chọn của bạn ");
                            int choice1 = Integer.parseInt(scanner.nextLine());
                            if (choice1 < 1 || choice1 > 4) {
                                System.out.println("Hãy nhập lựa chọn có trong MENU EMPLOYEE MANAGEMENT");
                            } else {
                                switch (choice1) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                }
                            }
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("------------------------------------");
                        System.out.println("MENU CUSTOMER MANAGEMENT");
                        System.out.println("1. Display list customers");
                        System.out.println("2. Add new customers");
                        System.out.println("3. Edit customers");
                        System.out.println("4. Return main menu");
                        System.out.println("Hãy nhập lựa chọn của bạn ");
                        int choice2 = Integer.parseInt(scanner.nextLine());
                        if (choice2 < 1 || choice2 > 4) {
                            System.out.println("Hãy nhập lựa chọn có trong MENU EMPLOYEE MANAGEMENT");
                        } else {
                            switch (choice2) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                            break;
                        }
                        break;
                    case 3:
                        System.out.println("------------------------------------");
                        System.out.println("MENU FACILITY MANAGEMENT");
                        System.out.println("1. Display list facility");
                        System.out.println("2. Add new facility");
                        System.out.println("3. Display list facility maintenance");
                        System.out.println("4. Return main menu");
                        System.out.println("Hãy nhập lựa chọn của bạn ");
                        int choice3 = Integer.parseInt(scanner.nextLine());
                        if (choice3 < 1 || choice3 > 4) {
                            System.out.println("Hãy nhập lựa chọn có trong MENU FACILITY MANAGEMENT");
                        } else {
                            switch (choice3) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                            break;
                        }
                        break;
                    case 4:
                        System.out.println("------------------------------------");
                        System.out.println("MENU BOOKING MANAGEMENT");
                        System.out.println("1. Add new booking");
                        System.out.println("2. Display list booking");
                        System.out.println("3. Create new constracts");
                        System.out.println("4. Display list contracts");
                        System.out.println("5. Edit contracts");
                        System.out.println("6. Return main menu");
                        System.out.println("Hãy nhập lựa chọn của bạn ");
                        int choice4 = Integer.parseInt(scanner.nextLine());
                        if (choice4 < 1 || choice4 > 6) {
                            System.out.println("Hãy nhập lựa chọn có trong MENU BOOKING MANAGEMENT");
                        } else {
                            switch (choice4) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                            }
                            break;
                        }
                        break;
                    case 5:
                        System.out.println("------------------------------------");
                        System.out.println("MENU PROMOTION  MANAGEMENT");
                        System.out.println("1. Display list customers use service");
                        System.out.println("2. Display list customers get voucher");
                        System.out.println("3. Return main menu");
                        System.out.println("Hãy nhập lựa chọn của bạn ");
                        int choice5 = Integer.parseInt(scanner.nextLine());
                        if (choice5 < 1 || choice5 > 3) {
                            System.out.println("Hãy nhập lựa chọn có trong MENU PROMOTION MANAGEMENT");
                        } else {
                            switch (choice5) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                            }
                            break;
                        }
                        break;
                    case 6:
                        System.out.println("Cám ơn bạn đã sử dụng ứng dụng");
                        return;
                }
            }
        }

    }
}
