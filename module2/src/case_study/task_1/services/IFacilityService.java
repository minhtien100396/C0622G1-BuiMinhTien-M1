package case_study.task_1.services;

import java.io.IOException;

public interface IFacilityService extends IService {

    void addNewVilla() throws IOException;

    void displayListFacility() throws IOException;

    void addNewHouse() throws IOException;

    void addNewRoom() throws IOException;

    void displayListFacilityMaintenance() throws IOException;

    void maintenanceFacility() throws IOException;
}
