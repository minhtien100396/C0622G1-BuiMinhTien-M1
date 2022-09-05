package case_study.task_1.utils;

import case_study.task_1.models.Villa;
import case_study.task_1.utils.validate.input_villa.InputIdServiceOfVillaUltils;
import case_study.task_1.utils.validate.input_facility.InputNumberOfFloorsUltils;
import case_study.task_1.utils.validate.input_villa.InputPoolAreaUltils;
import case_study.task_1.utils.validate.input_facility.InputRoomStandardUltils;

public class InputVilla extends InputFacility {
    static String roomStandard;
    static double poolArea;
    static int numberOfFloors;
    static String serviceName = "Villa";

    public static Villa inputVilla() {
        idService = InputIdServiceOfVillaUltils.inputId();
        InputFacility.inputFacility();
        roomStandard = InputRoomStandardUltils.inputRoomStandardUltils();
        poolArea = InputPoolAreaUltils.inputPoolAreaUltils();
        numberOfFloors = InputNumberOfFloorsUltils.inputNumberOfFloorsUltils();
        Villa villa = new Villa(idService, serviceName, usableArea, rentalCosts,
                maximumNumberOfPeople, rentalType, roomStandard, poolArea,
                numberOfFloors);
        return villa;
    }
}
