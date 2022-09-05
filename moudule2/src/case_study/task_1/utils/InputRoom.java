package case_study.task_1.utils;

import case_study.task_1.models.Room;
import case_study.task_1.utils.validate.input_room.InputFreeServiceIncludedUltils;
import case_study.task_1.utils.validate.input_room.InputIdServiceOfRoomUltils;

public class InputRoom extends InputFacility {
    static String freeServiceIncluded;
    static String serviceName = "Room";

    public static Room inputRoom() {
        idService = InputIdServiceOfRoomUltils.inputId();
        InputFacility.inputFacility();
        freeServiceIncluded = InputFreeServiceIncludedUltils.inputFreeServiceIncludedUltils();
        Room room = new Room(idService, serviceName, usableArea, rentalCosts,
                maximumNumberOfPeople, rentalType, freeServiceIncluded);
        return room;
    }
}
