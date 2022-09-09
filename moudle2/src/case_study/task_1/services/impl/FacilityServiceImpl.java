package case_study.task_1.services.impl;

import case_study.task_1.models.Facility;
import case_study.task_1.models.House;
import case_study.task_1.models.Room;
import case_study.task_1.models.Villa;
import case_study.task_1.services.IFacilityService;
import case_study.task_1.utils.InputHouse;
import case_study.task_1.utils.InputRoom;
import case_study.task_1.utils.InputVilla;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    private Scanner scanner = new Scanner(System.in);
    public static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> listFacilityMaintenance = new LinkedHashMap<>();

    Map<Villa, Integer> villaList = new LinkedHashMap<>();
    Map<House, Integer> houseList = new LinkedHashMap<>();
    Map<Room, Integer> roomList = new LinkedHashMap<>();
    private final String VILLA_FILE = "src\\case_study\\task_1\\data\\villa.csv";
    private final String HOUSE_FILE = "src\\case_study\\task_1\\data\\house.csv";
    private final String ROOM_FILE = "src\\case_study\\task_1\\data\\room.csv";
    private final String FACILITY_FILE = "src\\case_study\\task_1\\data\\facility.csv";
    private final String MENTEN_FACILITY_FILE = "src\\case_study\\task_1\\data\\menten_facility.csv";


    @Override
    public void displayListFacility() throws IOException {
        facilityIntegerMap = ReadFileUtils.readFileFacility(FACILITY_FILE);
        for (Facility facility : facilityIntegerMap.keySet()) {
            if (facilityIntegerMap.get(facility) >= 5) {
                listFacilityMaintenance.put(facility, facilityIntegerMap.get(facility));
            }
        }
        for (Facility facility1 : listFacilityMaintenance.keySet()) {
            facilityIntegerMap.remove(facility1);
        }
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Không có bất kì thông tin về cơ sở vật chất trong danh sách");
        } else {
            System.out.println("------------------------------------");
            System.out.println("DANH SÁCH CƠ SỞ VẬT CHẤT");
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                System.out.println(entry.getKey() + "|" + entry.getValue());
            }
        }
        WriteFileUtils.writeFileFacility(FACILITY_FILE, facilityIntegerMap);
        WriteFileUtils.writeFileFacility(MENTEN_FACILITY_FILE, listFacilityMaintenance);
    }

    @Override
    public void addNewVilla() throws IOException {
        facilityIntegerMap = ReadFileUtils.readFileFacility(FACILITY_FILE);
        Villa villa = this.infoVilla();
        facilityIntegerMap.put(villa, 0);
        villaList.put(villa, 0);
        System.out.println("Bạn đã thêm thành công");
        WriteFileUtils.writeFileVilla(VILLA_FILE, villaList);
        WriteFileUtils.writeFileFacility(FACILITY_FILE, facilityIntegerMap);
    }

    @Override
    public void addNewHouse() throws IOException {
        facilityIntegerMap = ReadFileUtils.readFileFacility(FACILITY_FILE);
        House house = this.infoHouse();
        facilityIntegerMap.put(house, 0);
        houseList.put(house, 0);
        System.out.println("Bạn đã thêm thành công");
        WriteFileUtils.writeFileHouse(HOUSE_FILE, houseList);
        WriteFileUtils.writeFileFacility(FACILITY_FILE, facilityIntegerMap);
    }

    @Override
    public void addNewRoom() throws IOException {
        facilityIntegerMap = ReadFileUtils.readFileFacility(FACILITY_FILE);
        Room room = this.infoRoom();
        facilityIntegerMap.put(room, 0);
        roomList.put(room, 0);
        System.out.println("Bạn đã thêm thành công");
        WriteFileUtils.writeFileRoom(ROOM_FILE, roomList);
        WriteFileUtils.writeFileFacility(FACILITY_FILE, facilityIntegerMap);
    }

    @Override
    public void displayListFacilityMaintenance() throws IOException {
        facilityIntegerMap = ReadFileUtils.readFileFacility(FACILITY_FILE);
        listFacilityMaintenance = ReadFileUtils.readFileFacility(MENTEN_FACILITY_FILE);
        for (Facility facility : facilityIntegerMap.keySet()) {
            if (facilityIntegerMap.get(facility) >= 5) {
                listFacilityMaintenance.put(facility, facilityIntegerMap.get(facility));
            }
        }
        for (Facility facility1 : listFacilityMaintenance.keySet()) {
            facilityIntegerMap.remove(facility1);
        }
        if (listFacilityMaintenance.isEmpty()) {
            System.out.println("Không có Cơ sở vật chất cần bảo trì");
        } else {
            System.out.println("------------------------------------");
            System.out.println("DANH SÁCH CƠ SỞ VẬT CHẤT CẦN BẢO TRÌ");
            for (Facility facility : listFacilityMaintenance.keySet()) {
                System.out.println(facility + "|" + listFacilityMaintenance.get(facility));
            }
        }
        WriteFileUtils.writeFileFacility(FACILITY_FILE, facilityIntegerMap);
        WriteFileUtils.writeFileFacility(MENTEN_FACILITY_FILE, listFacilityMaintenance);
    }

    @Override
    public void maintenanceFacility() throws IOException {
        facilityIntegerMap = ReadFileUtils.readFileFacility(FACILITY_FILE);
        if (listFacilityMaintenance.isEmpty()) {
            System.out.println("Không có Cơ sở vật chất cần bảo trì");
        } else {
            for (Facility facility : listFacilityMaintenance.keySet()) {
                facilityIntegerMap.put(facility, 0);
            }
        }
        listFacilityMaintenance.clear();
        WriteFileUtils.writeFileFacility(FACILITY_FILE, facilityIntegerMap);
        WriteFileUtils.writeFileFacility(MENTEN_FACILITY_FILE, listFacilityMaintenance);
    }


    public static Villa infoVilla() {
        System.out.println("Mời bạn nhập vào thông tin cho Villa: ");
        Villa villa = InputVilla.inputVilla();
        return villa;
    }

    public static House infoHouse() {
        System.out.println("Mời bạn nhập vào thông tin cho House: ");
        House house = InputHouse.inputHouse();
        return house;
    }

    public static Room infoRoom() {
        System.out.println("Mời bạn nhập vào thông tin cho Room: ");
        Room room = InputRoom.inputRoom();
        return room;
    }
}
