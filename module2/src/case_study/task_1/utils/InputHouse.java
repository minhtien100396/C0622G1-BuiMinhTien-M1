package case_study.task_1.utils;

import case_study.task_1.models.House;
import case_study.task_1.utils.validate.input_house.InputIdServiceOfHouseUltils;
import case_study.task_1.utils.validate.input_facility.InputNumberOfFloorsUltils;
import case_study.task_1.utils.validate.input_facility.InputRoomStandardUltils;

public class InputHouse extends InputFacility {
    static String roomStandard;
    static String serviceName = "House";
    static int numberOfFloors;

    public static House inputHouse() {
        idService = InputIdServiceOfHouseUltils.inputId();
        InputFacility.inputFacility();
        roomStandard = InputRoomStandardUltils.inputRoomStandardUltils();
        numberOfFloors = InputNumberOfFloorsUltils.inputNumberOfFloorsUltils();
        House house = new House(idService, serviceName, usableArea, rentalCosts,
                maximumNumberOfPeople, rentalType, roomStandard,
                numberOfFloors);
        return house;
    }
}
