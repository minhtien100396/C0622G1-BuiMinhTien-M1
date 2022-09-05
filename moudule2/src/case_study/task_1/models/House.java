package case_study.task_1.models;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String idService, String serviceName, double usableArea, double rentalCosts,
                 int maximumNumberOfPeople, String rentalType, String roomStandard, int numberOfFloors) {
        super(idService, serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getIdService(), this.getServiceName(), this.getUsableArea(), this.getRentalCosts(),
                this.getMaximumNumberOfPeople(), this.getRentalType(), roomStandard,
                numberOfFloors);
    }
}
