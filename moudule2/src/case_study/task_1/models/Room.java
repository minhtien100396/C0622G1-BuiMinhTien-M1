package case_study.task_1.models;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String idService, String serviceName, double usableArea, double rentalCosts,
                int maximumNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(idService, serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
//        return "Room{" +
//                "FreeServiceIncluded='" + FreeServiceIncluded + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.getIdService(), this.getServiceName(), this.getUsableArea(), this.getRentalCosts(),
                this.getMaximumNumberOfPeople(), this.getRentalType(),freeServiceIncluded);
    }
}
