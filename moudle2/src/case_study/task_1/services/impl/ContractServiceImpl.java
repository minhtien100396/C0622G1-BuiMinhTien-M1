package case_study.task_1.services.impl;

import case_study.task_1.models.Booking;
import case_study.task_1.models.Contract;
import case_study.task_1.services.IContractService;
import case_study.task_1.utils.InputContracts;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;
import case_study.task_1.utils.validate.input_contract.InputDeposit;
import case_study.task_1.utils.validate.input_contract.InputIdContract;
import case_study.task_1.utils.validate.input_contract.InputTotalPayment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ContractServiceImpl implements IContractService {
    Scanner scanner = new Scanner(System.in);
    private static List<Contract> contracts = new LinkedList<>();
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    private final String CONTRACTS_FILE = "src\\case_study\\task_1\\data\\contracts.csv";

    @Override
    public void createNewConstracts() throws IOException {
        contracts = ReadFileUtils.readFileContracts(CONTRACTS_FILE);
        bookingQueue = ReadFileUtils.readFileQueueBooking("src\\case_study\\task_1\\data\\queue_booking.csv");
        Contract contract = this.infoContract();
        contracts.add(contract);
        bookingQueue.remove();
        System.out.println("Bạn đã thêm thành công");
        WriteFileUtils.writeFileContracts(CONTRACTS_FILE, contracts);
        WriteFileUtils.writeFileQueueBooking("src\\case_study\\task_1\\data\\queue_booking.csv", bookingQueue);
    }

    @Override
    public void displayListContracts() throws IOException {
        contracts = ReadFileUtils.readFileContracts(CONTRACTS_FILE);
        if (contracts.isEmpty()) {
            System.out.println("Không có bất kì thông tin hợp đồng nào trong danh sách");
        } else {
            System.out.println("------------------------------------");
            System.out.println("DANH SÁCH HỢP ĐỒNG");
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    @Override
    public void editContracts() throws IOException {
        contracts = ReadFileUtils.readFileContracts(CONTRACTS_FILE);
        String id;
        int choice;
        boolean check = false;
        displayListContracts();
        System.out.println("-------------------------------------------------------------");
        System.out.println("Mời bạn nhập vào Mã Số Hợp đồng muốn chỉnh sửa (MSHD-XXXXX)");
        id = scanner.nextLine();
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getIdContract().equals(id)) {
                System.out.println("Bạn có chắc chắn muốn thay đổi thông tin hợp đồng có ID là " + contracts.get(i).getIdContract() + " không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    contracts.get(i).setIdContract(InputIdContract.inputId());
                    contracts.get(i).setDeposit(InputDeposit.inputDeposit());
                    contracts.get(i).setTotalPayment(InputTotalPayment.inputTotalPayment());
                    System.out.println("Bạn đã chỉnh sửa thành công");
                    WriteFileUtils.writeFileContracts(CONTRACTS_FILE, contracts);
                    check = true;
                    break;
                } else if (choice == 2) {
                    return;
                }
            }
        }
        if (!check) {
            System.out.println("Mã Hợp Đồng bạn nhập không tồn tại. Vui lòng kiểm tra lại!");
        }

    }

    public Contract infoContract() throws IOException {
        System.out.println("Mời bạn nhập vào thông tin để khởi tạo hợp đồng: ");
        Contract contract = InputContracts.inputContracts();
        return contract;
    }

}
