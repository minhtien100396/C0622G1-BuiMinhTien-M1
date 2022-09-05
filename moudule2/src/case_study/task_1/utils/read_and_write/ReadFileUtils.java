package case_study.task_1.utils.read_and_write;

import case_study.task_1.models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ReadFileUtils {
    private static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> strings = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();

        return strings;
    }

    public static List<Employee> readFileEmployee(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Employee> employeeList = new ArrayList<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                employeeList.add(new Employee(info[0], LocalDate.parse(info[1]), info[2], info[3], info[4], info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File hiện tại đang trống");
        }

        return employeeList;
    }

    public static List<Customer> readFileCustomer(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Customer> customerList = new LinkedList<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                customerList.add(new Customer(info[0], LocalDate.parse(info[1]), info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File hiện tại đang trống");
        }

        return customerList;
    }

    public static Map<Villa, Integer> readFileVilla(String path) throws IOException {
        List<String> strings = readFile(path);
        Map<Villa, Integer> villaList = new LinkedHashMap<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                villaList.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])), Integer.parseInt(info[9]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File hiện tại đang trống");
        }

        return villaList;
    }

    public static Map<House, Integer> readFileHouse(String path) throws IOException {
        List<String> strings = readFile(path);
        Map<House, Integer> houseList = new LinkedHashMap<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                houseList.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File hiện tại đang trống");
        }

        return houseList;
    }

    public static Map<Room, Integer> readFileRoom(String path) throws IOException {
        List<String> strings = readFile(path);
        Map<Room, Integer> roomList = new LinkedHashMap<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                roomList.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File hiện tại đang trống");
        }

        return roomList;
    }

    public static Map<Facility, Integer> readFileFacility(String path) throws IOException {
        List<String> strings = readFile(path);
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                if (info[0].contains("SVVL")) {
                    facilityMap.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])), Integer.parseInt(info[9]));
                }
                if (info[0].contains("SVHO")) {
                    facilityMap.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
                }
                if (info[0].contains("SVRO")) {
                    facilityMap.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File hiện tại đang trống");
        }

        return facilityMap;
    }

    public static Set<Booking> readFileBooking(String path) throws IOException {
        List<String> strings = readFile(path);
        Set<Booking> bookingList = new TreeSet<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                bookingList.add(new Booking(info[0], info[1], info[2], info[3], info[4], info[5]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        return bookingList;
    }
}
