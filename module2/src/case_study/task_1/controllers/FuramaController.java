package case_study.task_1.controllers;

import case_study.task_1.services.*;
import case_study.task_1.services.impl.*;
import case_study.task_1.utils.exception.ChoiceException;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        IEmployeeService employeeService = new EmployeeServiceImpl();
        ICustomerService customerService = new CustomerServiceImpl();
        IFacilityService facilityService = new FacilityServiceImpl();
        IBookingService bookingService =  new BookingServiceImpl();
        IContractService contractService = new ContractServiceImpl();
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
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 6) {
                    throw new ChoiceException("Hãy nhập lựa chọn có trong MENU");
                } else {
                    switch (choice) {
                        case 1:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("MENU EMPLOYEE MANAGEMENT ");
                                System.out.println("1. Display list employee");
                                System.out.println("2. Add new employee");
                                System.out.println("3. Edit employee");
                                System.out.println("4. Delete employee");
                                System.out.println("5. Sort by name");
                                System.out.println("6. Sort by salary");
                                System.out.println("7. Search by IdEmployee");
                                System.out.println("8. Return main menu");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Hãy nhập lựa chọn của bạn");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 8) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU EMPLOYEE MANAGEMENT");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                employeeService.displayListEmployee();
                                                check = true;
                                                break;
                                            case 2:
                                                employeeService.addEmployee();
                                                check = true;
                                                break;
                                            case 3:
                                                employeeService.editEmployee();
                                                check = true;
                                                break;
                                            case 4:
                                                employeeService.deleteEmployee();
                                                check = true;
                                                break;
                                            case 5:
                                                employeeService.sortName();
                                                check = true;
                                                break;
                                            case 6:
                                                employeeService.sortSalary();
                                                check = true;
                                                break;
                                            case 7:
                                                employeeService.searchIdEmployee();
                                                check = true;
                                                break;
                                            case 8:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 2:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("MENU CUSTOMER MANAGEMENT");
                                System.out.println("1. Display list customers");
                                System.out.println("2. Add new customers");
                                System.out.println("3. Edit customers");
                                System.out.println("4. Return main menu");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Hãy nhập lựa chọn của bạn ");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 4) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU CUSTOMER MANAGEMENT");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                customerService.displayListCustomer();
                                                check = true;
                                                break;
                                            case 2:
                                                customerService.addCustomer();
                                                check = true;
                                                break;
                                            case 3:
                                                customerService.editCustomer();
                                                check = true;
                                                break;
                                            case 4:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 3:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("MENU FACILITY MANAGEMENT");
                                System.out.println("1. Display list facility");
                                System.out.println("2. Add new facility");
                                System.out.println("3. Display list facility maintenance");
                                System.out.println("4. Menten list facility maintenance");
                                System.out.println("5. Return main menu");
                                boolean check = false;
                                int choice1;
                                int choice2;
                                try {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Hãy nhập lựa chọn của bạn ");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 5) {
                                        throw new ChoiceException("Lựa chọn của bạn không hợp lệ");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                facilityService.displayListFacility();
                                                check = true;
                                                break;
                                            case 2:
                                                while (true) {
                                                    System.out.println("Hãy lựa chọn loại hình dịch vụ bạn muốn thêm vào");
                                                    System.out.println("1. New Villa");
                                                    System.out.println("2. New House");
                                                    System.out.println("3. New Room");
                                                    System.out.println("4. Back to menu");
                                                    boolean check1 = false;
                                                    try {
                                                        choice2 = Integer.parseInt(scanner.nextLine());
                                                        if (choice2 < 1 || choice2 > 4) {
                                                            throw new ChoiceException("Hãy nhập lựa chọn có trong MENU FACILITY MANAGEMENT");
                                                        } else {
                                                            switch (choice2) {
                                                                case 1:
                                                                    facilityService.addNewVilla();
                                                                    check1 = true;
                                                                    break;
                                                                case 2:
                                                                    facilityService.addNewHouse();
                                                                    check1 = true;
                                                                    break;
                                                                case 3:
                                                                    facilityService.addNewRoom();
                                                                    check1 = true;
                                                                    break;
                                                                case 4:
                                                                    break;
                                                            }
                                                        }

                                                    } catch (ChoiceException e) {
                                                        check1 = true;
                                                        System.out.println(e.getMessage());
                                                    }catch (NumberFormatException e) {
                                                        check1 = true;
                                                        System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                    if (!check1) {
                                                        break;
                                                    }
                                                }

                                                check = true;
                                                break;
                                            case 3:
                                                facilityService.displayListFacilityMaintenance();
                                                check = true;
                                                break;
                                            case 4:
                                                facilityService.maintenanceFacility();
                                                check = true;
                                                break;
                                            case 5:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 4:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("MENU BOOKING MANAGEMENT");
                                System.out.println("1. Add new booking");
                                System.out.println("2. Display list booking");
                                System.out.println("3. Create new constracts");
                                System.out.println("4. Display list contracts");
                                System.out.println("5. Edit contracts");
                                System.out.println("6. Return main menu");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Hãy nhập lựa chọn của bạn ");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 6) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU BOOKING MANAGEMENT");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                bookingService.addBooking();
                                                check = true;
                                                break;
                                            case 2:
                                                bookingService.displayBooking();
                                                check = true;
                                                break;
                                            case 3:
                                                contractService.createNewConstracts();
                                                check = true;
                                                break;
                                            case 4:
                                                contractService.displayListContracts();
                                                check = true;
                                                break;
                                            case 5:
                                                contractService.editContracts();
                                                check = true;
                                                break;
                                            case 6:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
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
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập đúng lựa chọn trên menu");
            }
        }
    }
}
