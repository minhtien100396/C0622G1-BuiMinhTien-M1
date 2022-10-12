package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.models.Facility;
import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class InputIdService {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^(SVHO|SVVL|SVRO)\\-[0-9]{1,5}$";

    public static String inputIdService() throws IOException {
        String id;
        boolean check;
        Map<Facility, Integer> facilityIntegerMap = ReadFileUtils.readFileFacility("src\\case_study\\task_1\\data\\facility.csv");
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã số Dịch Vụ (SVVL|SVHO|SVRO-XXXXX)");
                id = scanner.nextLine();
                check = false;
                for (Facility facility : facilityIntegerMap.keySet()) {
                    if ((facility.getIdService().equals(id))) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    throw new DuplicatePersomnalRecordException("ID bạn nhập không có trong danh sách Cơ sở vật chất. Vui lòng nhập lại");
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("ID không hợp lệ. Hãy kiểm tra lại!");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}

