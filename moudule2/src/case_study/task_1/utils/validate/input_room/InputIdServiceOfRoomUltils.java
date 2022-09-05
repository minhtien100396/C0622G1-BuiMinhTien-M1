package case_study.task_1.utils.validate.input_room;

import case_study.task_1.models.Facility;
import case_study.task_1.services.impl.FacilityServiceImpl;
import case_study.task_1.utils.exception.IdException;

import java.util.Map;
import java.util.Scanner;

public class InputIdServiceOfRoomUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^SVRO\\-[0-9]{1,5}$";


    public static String inputId() {
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã Dịch Vụ cho Room (SVRO-YYYY)");
                id = scanner.nextLine();
                for (Map.Entry<Facility,Integer> entry: FacilityServiceImpl.facilityIntegerMap.entrySet()) {
                    if (entry.getKey().getIdService().equals(id)){
                        throw new IdException("ID bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new IdException("Mã dịch vụ không hợp lệ. Hãy kiểm tra lại! (SVRO-YYYY)");
                }
            } catch (IdException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
