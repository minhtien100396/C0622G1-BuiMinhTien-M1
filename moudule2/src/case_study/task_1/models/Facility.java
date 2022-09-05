package case_study.task_1.models;

import java.util.Objects;

public abstract class Facility {
    private String idService;
    private String ServiceName;
    private double UsableArea;
    private double RentalCosts;
    private int MaximumNumberOfPeople;
    private String RentalType;

    public Facility() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(idService, facility.idService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService);
    }

    public Facility(String idService, String serviceName, double usableArea, double rentalCosts,
                    int maximumNumberOfPeople, String rentalType) {
        this.idService = idService;
        ServiceName = serviceName;
        UsableArea = usableArea;
        RentalCosts = rentalCosts;
        MaximumNumberOfPeople = maximumNumberOfPeople;
        RentalType = rentalType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public double getUsableArea() {
        return UsableArea;
    }

    public void setUsableArea(double usableArea) {
        UsableArea = usableArea;
    }

    public double getRentalCosts() {
        return RentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        RentalCosts = rentalCosts;
    }

    public int getMaximumNumberOfPeople() {
        return MaximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        MaximumNumberOfPeople = maximumNumberOfPeople;
    }

    public String getRentalType() {
        return RentalType;
    }

    public void setRentalType(String rentalType) {
        RentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idService='" + idService + '\'' +
                ", ServiceName='" + ServiceName + '\'' +
                ", UsableArea=" + UsableArea +
                ", RentalCosts=" + RentalCosts +
                ", MaximumNumberOfPeople=" + MaximumNumberOfPeople +
                ", RentalType='" + RentalType + '\'' +
                '}';
    }
}
