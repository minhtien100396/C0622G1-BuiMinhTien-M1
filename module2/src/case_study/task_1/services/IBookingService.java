package case_study.task_1.services;

import java.io.IOException;

public interface IBookingService extends IService {
    void addBooking() throws IOException;

    void displayBooking() throws IOException;
}
