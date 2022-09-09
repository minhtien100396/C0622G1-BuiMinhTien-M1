package case_study.task_1.utils.read_and_write;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import case_study.task_1.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WriteFileUtils {
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeFileEmployee(String path, List<Employee> employeeList) throws IOException {
        String data = "";
        for (Employee employee : employeeList) {
            data += employee.toString();
            //     data += employee.getInfo();
            data += "\n";
        }

        writeFile(path, data);
    }

    public static void writeFileCustomer(String path, List<Customer> customerList) throws IOException {
        String data = "";
        for (Customer customer : customerList) {
            data += customer.toString();
            data += "\n";
        }

        writeFile(path, data);
    }

    public static void writeFileVilla(String path, Map<Villa, Integer> villaList) throws IOException {
        String data = "";
        for (Villa villa : villaList.keySet()) {
            data += villa.toString() + "," + villaList.get(villa);
            data += "\n";
        }

        writeFile(path, data);
    }

    public static void writeFileHouse(String path, Map<House, Integer> houseList) throws IOException {
        String data = "";
        for (House house : houseList.keySet()) {
            data += house.toString() + "," + houseList.get(house);
            data += "\n";
        }

        writeFile(path, data);
    }

    public static void writeFileRoom(String path, Map<Room, Integer> roomList) throws IOException {
        String data = "";
        for (Room room : roomList.keySet()) {
            data += room.toString() + "," + roomList.get(room);
            data += "\n";
        }

        writeFile(path, data);
    }

    public static void writeFileFacility(String path, Map<Facility, Integer> facilityMap) throws IOException {
        String data = "";
        for (Facility facility : facilityMap.keySet()) {
            data += facility.toString() + "," + facilityMap.get(facility);
            data += "\n";
        }
        writeFile(path, data);
    }

    public static void writeFileBooking(String path, Set<Booking> bookingSet) throws IOException {
        String data = "";
        for (Booking booking : bookingSet) {
            data += booking.toString();
            data += "\n";
        }

        writeFile(path, data);
    }

    public static void writeFileContracts(String path, List<Contract> contracts) throws IOException {
        String data = "";
        for (Contract contract : contracts) {
            data += contract.toString();
            data += "\n";
        }

        writeFile(path, data);
    }
    public static void writeFileQueueBooking(String path, Queue<Booking> bookingQueue) throws IOException {
        String data = "";
        for (Booking booking : bookingQueue) {
            data += booking.toString();
            data += "\n";
        }

        writeFile(path, data);
    }
}
