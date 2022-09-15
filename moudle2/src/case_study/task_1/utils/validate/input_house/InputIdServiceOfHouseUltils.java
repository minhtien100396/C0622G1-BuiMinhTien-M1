package case_study.task_1.utils.validate.input_house;

import case_study.task_1.models.Facility;
import case_study.task_1.services.impl.FacilityServiceImpl;
import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;

import java.util.Map;
import java.util.Scanner;

public class InputIdServiceOfHouseUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^SVHO\\-[0-9]{1,5}$";


    public static String inputId() {
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã Dịch Vụ cho House (SVHO-YYYY)");
                id = scanner.nextLine();
                for (Map.Entry<Facility,Integer> entry: FacilityServiceImpl.facilityIntegerMap.entrySet()) {
                    if (entry.getKey().getIdService().equals(id)){
                        throw new DuplicatePersomnalRecordException("ID bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("Mã dịch vụ không hợp lệ. Hãy kiểm tra lại! (SVHO-YYYY)");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}