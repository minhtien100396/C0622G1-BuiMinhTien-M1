package case_study.task_1.services.impl;

import case_study.task_1.models.Booking;
import case_study.task_1.models.Customer;
import case_study.task_1.models.Facility;
import case_study.task_1.services.IBookingService;
import case_study.task_1.utils.InputBooking;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;

import java.io.IOException;
import java.util.*;

public class BookingServiceImpl implements IBookingService {
    private static Set<Booking> bookingSet = new TreeSet<>();
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    private final String BOOKING_FILE = "src\\case_study\\task_1\\data\\booking.csv";
    private final String BOOKING_QUEUE_FILE ="src\\case_study\\task_1\\data\\queue_booking.csv";
    @Override
    public void addBooking() throws IOException {
        bookingSet = ReadFileUtils.readFileBooking(BOOKING_FILE);
        bookingQueue = ReadFileUtils.readFileQueueBooking(BOOKING_QUEUE_FILE);
        Map<Facility, Integer> facilityIntegerMap = ReadFileUtils.readFileFacility("src\\case_study\\task_1\\data\\facility.csv");
        List<Customer> customerList = ReadFileUtils.readFileCustomer("src\\case_study\\task_1\\data\\customer.csv");
        if (customerList.isEmpty()) {
            System.out.println("Không có Khách Hàng cần Booking!");
            return;
        }else if (facilityIntegerMap.isEmpty()){
            System.out.println("Không có cơ sở vật chất để Book. Hãy thêm cơ sở vật chất vào danh sách");
        }
        Booking booking = this.infoBooking();
        if (booking.getIdService().contains("SVVL")||booking.getIdService().contains("SVHO")){
            bookingQueue.add(booking);
        }
        bookingSet.add(booking);
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (booking.getIdService().equals(entry.getKey().getIdService())) {
                facilityIntegerMap.put(entry.getKey(), facilityIntegerMap.get(entry.getKey()) + 1);
                WriteFileUtils.writeFileFacility("src\\case_study\\task_1\\data\\facility.csv", facilityIntegerMap);
            }
        }
        System.out.println("Bạn đã Booking thành công");
        WriteFileUtils.writeFileBooking(BOOKING_FILE, bookingSet);
        WriteFileUtils.writeFileQueueBooking(BOOKING_QUEUE_FILE,bookingQueue);
    }

    @Override
    public void displayBooking() throws IOException {
        bookingSet = ReadFileUtils.readFileBooking(BOOKING_FILE);
        if (bookingSet.isEmpty()) {
            System.out.println("Không có bất kì thông tin booking nào trong danh sách");
        } else {
            System.out.println("------------------------------------");
            System.out.println("DANH SÁCH BOOKING");
            for (Booking booking : bookingSet) {
                System.out.println(booking);
            }
        }
    }

    public Booking infoBooking() throws IOException {
        System.out.println("----------------------------------------------------");
        System.out.println("Mời bạn nhập vào thông tin Booking");
        Booking booking = InputBooking.inputBooking();
        return booking;
    }

}
