package case_study.task_1.utils;

import case_study.task_1.utils.validate.input_facility.InputMaximumNumberOfPeopleUltils;
import case_study.task_1.utils.validate.input_facility.InputRentalCostsUltils;
import case_study.task_1.utils.validate.input_facility.InputRentalTypeUltils;
import case_study.task_1.utils.validate.input_facility.InputUsableAreaUltils;

public class InputFacility {
    static String idService;
    static double usableArea;
    static double rentalCosts;
    static int maximumNumberOfPeople;
    static String rentalType;

    public static void inputFacility() {
        usableArea = InputUsableAreaUltils.inputUsableAreaUltils();
        rentalCosts = InputRentalCostsUltils.inputRentalCostsUltils();
        maximumNumberOfPeople = InputMaximumNumberOfPeopleUltils.inputMaximumNumberOfPeopleUltils();
        rentalType = InputRentalTypeUltils.inputRentalTypeUltils();
    }
}
