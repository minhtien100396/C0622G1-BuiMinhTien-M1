package case_study.task_1.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Booking implements Comparable<Booking> {
    private String idBooking;
    private String startDay;
    private String endDay;
    private String idCustomer;
    private String idService;
    private String typeService;

    public Booking() {
    }

    public Booking(String idBooking, String startDay, String endDay, String idCustomer,
                   String nameService, String typeService) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer;
        this.idService = nameService;
        this.typeService = typeService;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", idBooking, startDay, endDay, idCustomer, idService, typeService);
    }

    @Override
    public int compareTo(Booking o) {
        LocalDate startDayCheck;
        LocalDate startDayCheckObjecct;
        LocalDate endDayCheck;
        LocalDate endDayCheckObjecct;
        startDayCheck = LocalDate.parse(this.startDay, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        startDayCheckObjecct = LocalDate.parse(o.startDay, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        endDayCheck = LocalDate.parse(this.endDay, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        endDayCheckObjecct = LocalDate.parse(o.endDay, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        if (startDayCheck.compareTo(startDayCheckObjecct) != 0) {
            return startDayCheck.compareTo(startDayCheckObjecct);
        } else  {
            return endDayCheck.compareTo(endDayCheckObjecct);
        }
    }
}
