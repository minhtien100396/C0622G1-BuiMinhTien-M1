package case_study.task_1.utils;

import case_study.task_1.models.Booking;
import case_study.task_1.models.Contract;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.validate.input_contract.InputDeposit;
import case_study.task_1.utils.validate.input_contract.InputIdContract;
import case_study.task_1.utils.validate.input_contract.InputTotalPayment;

import java.io.IOException;
import java.util.Queue;

public class InputContracts {
    private static String idContracts;
    private static String idBooking;
    private static Double deposit;
    private static Double totalPayment;
    private static String idCustomer;
    public static Contract inputContracts() throws IOException {
        Queue<Booking> bookingQueue = ReadFileUtils.readFileQueueBooking("src\\case_study\\task_1\\data\\queue_booking.csv");
        idContracts = InputIdContract.inputId();
        idBooking = bookingQueue.peek().getIdBooking();
        deposit = InputDeposit.inputDeposit();
        totalPayment = InputTotalPayment.inputTotalPayment();
        idCustomer =  bookingQueue.peek().getIdCustomer();
        Contract contract = new Contract(idContracts, idBooking, deposit, totalPayment, idCustomer);
        return contract;
    }
}
