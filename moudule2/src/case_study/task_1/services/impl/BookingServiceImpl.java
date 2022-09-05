package case_study.task_1.services.impl;

import case_study.task_1.models.Booking;
import case_study.task_1.models.Customer;
import case_study.task_1.models.Facility;
import case_study.task_1.services.IBookingService;
import case_study.task_1.utils.InputBooking;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    private static Set<Booking> bookingSet = new TreeSet<>();
    private final String BOOKING_FILE = "src\\case_study\\task_1\\data\\booking.csv";
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    public void addBooking() throws IOException {
        customerService.displayListCustomer();
        facilityService.displayListFacility();
        bookingSet = ReadFileUtils.readFileBooking(BOOKING_FILE);
        Map<Facility, Integer> facilityIntegerMap = ReadFileUtils.readFileFacility("src\\case_study\\task_1\\data\\facility.csv");
        List<Customer> customerList = ReadFileUtils.readFileCustomer("src\\case_study\\task_1\\data\\customer.csv");
        if (customerList.isEmpty()) {
            System.out.println("Không có Khách Hàng cần Booking!");
            return;
        }
        Booking booking = this.infoBooking();
        bookingSet.add(booking);
        for (Map.Entry<Facility,Integer> entry : facilityIntegerMap.entrySet()) {
            if (booking.getIdService().equals(entry.getKey().getIdService())) {
                facilityIntegerMap.put(entry.getKey(),facilityIntegerMap.get(entry.getKey())+1);
                WriteFileUtils.writeFileFacility("src\\case_study\\task_1\\data\\facility.csv",facilityIntegerMap);
            }
        }
        System.out.println("Bạn đã Booking thành công");
        WriteFileUtils.writeFileBooking(BOOKING_FILE, bookingSet);
    }
    @Override
    public void displayBooking() throws IOException {
        bookingSet = ReadFileUtils.readFileBooking(BOOKING_FILE);
        if (bookingSet.isEmpty()) {
            System.out.println("không có bất kì thông tin booking nào trong danh sách");
        } else {
            System.out.println("------------------------------------");
            System.out.println("DANH SÁCH KHÁCH HÀNG");
            for (Booking booking : bookingSet) {
                System.out.println(booking);
            }
        }
    }

    public Booking infoBooking() throws IOException {
        System.out.println("Mời bạn nhập vào thông tin Booking: ");
        Booking booking = InputBooking.inputBooking();
        return booking;
    }

}
