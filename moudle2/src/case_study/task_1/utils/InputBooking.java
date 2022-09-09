package case_study.task_1.utils;

import case_study.task_1.models.Booking;
import case_study.task_1.services.impl.CustomerServiceImpl;
import case_study.task_1.services.impl.FacilityServiceImpl;
import case_study.task_1.utils.exception.ChoiceException;
import case_study.task_1.utils.validate.input_booking.*;
import case_study.task_1.utils.validate.input_facility.InputNameServiceUltils;
import case_study.task_1.utils.validate.input_facility.InputRentalTypeUltils;
import case_study.task_1.utils.validate.input_house.InputIdServiceOfHouseUltils;
import case_study.task_1.utils.validate.input_room.InputIdServiceOfRoomUltils;
import case_study.task_1.utils.validate.input_villa.InputIdServiceOfVillaUltils;

import java.io.IOException;
import java.util.Scanner;

public class InputBooking {
    private static String idBooking;
    private static String startDay;
    private static String endDay;
    private static String idCustomer;
    private static String idService;
    private static String typeService;
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    public static Booking inputBooking() throws IOException {
        idBooking = InputIdBooking.inputId();
        facilityService.displayListFacility();
        idService = InputIdService.inputIdService();
        startDay = InputStartDay.inputStartDay();
        endDay = InputEndDay.inputEndDay(startDay);
        customerService.displayListCustomer();
        idCustomer = InputIdCustomer.inputIdCustomer();
        typeService = InputRentalTypeUltils.inputRentalTypeUltils();
        Booking booking = new Booking(idBooking, startDay, endDay, idCustomer, idService, typeService);
        return booking;
    }
    public static String getIdService(){
        return idService;
    }
}
