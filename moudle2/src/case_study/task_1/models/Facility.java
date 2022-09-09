package case_study.task_1.models;

import java.util.Objects;

public abstract class Facility {
    private String idService;
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maximumNumberOfPeople;
    private String rentalType;

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
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
        this.rentalType = rentalType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumNumberOfPeople() {
        return maximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        this.maximumNumberOfPeople = maximumNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idService='" + idService + '\'' +
                ", ServiceName='" + serviceName + '\'' +
                ", UsableArea=" + usableArea +
                ", RentalCosts=" + rentalCosts +
                ", MaximumNumberOfPeople=" + maximumNumberOfPeople +
                ", RentalType='" + rentalType + '\'' +
                '}';
    }
}
