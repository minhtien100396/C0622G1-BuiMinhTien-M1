package case_study.task_1.utils.validate.input_contract;

import case_study.task_1.models.Contract;
import case_study.task_1.services.impl.ContractServiceImpl;
import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputIdContract {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^MSHD\\-[0-9]{1,5}$";
    private static ContractServiceImpl contractService = new ContractServiceImpl();

    public static String inputId() throws IOException {
        List<Contract> contracts = ReadFileUtils.readFileContracts("src\\case_study\\task_1\\data\\contracts.csv");
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã số Contract (MSHD-YYYYY)");
                id = scanner.nextLine();
                for (Contract contract : contracts) {
                    if (contract.getIdContract().equals(id)){
                        throw new DuplicatePersomnalRecordException("ID bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("Mã Hợp Đồng không hợp lệ. Hãy kiểm tra lại! (MSHD-YYYY)");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
