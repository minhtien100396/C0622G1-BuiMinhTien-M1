package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.models.Customer;
import case_study.task_1.models.Facility;
import case_study.task_1.utils.exception.IdException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputIdService {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^(SVHO|SVVL|SVRO)\\-[0-9]{1,5}$";

    public static String inputIdService() throws IOException {
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã số Dịch Vụ (SVVL|SVHO|SVRO-XXXXX)");
                id = scanner.nextLine();
                boolean check=false;
                Map<Facility, Integer> facilityIntegerMap = ReadFileUtils.readFileFacility("src\\case_study\\task_1\\data\\facility.csv");
                for (Facility facility : facilityIntegerMap.keySet()) {
                    if ((facility.getIdService().equals(id))) {
                        check=true;
                        break;
                    }
                }
                if(!check){
                    throw new IdException("ID bạn nhập không có trong danh sách Cơ sở vật chất. Vui lòng nhập lại");
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new IdException("ID không hợp lệ. Hãy kiểm tra lại!");
                }
            } catch (IdException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}

