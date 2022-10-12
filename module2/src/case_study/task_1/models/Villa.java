package case_study.task_1.models;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloors;

    public Villa(String idService, String serviceName, double usableArea, double rentalCosts,
                 int maximumNumberOfPeople, String rentalType, String roomStandard, double poolArea,
                 int numberOfFloors) {
        super(idService, serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa() {
    }

    public Villa(String roomStandard, double poolArea, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
//        return "Villa{" +
//                "roomStandard='" + roomStandard + '\'' +
//                ", poolArea=" + poolArea +
//                ", numberOfFloors=" + numberOfFloors +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getIdService(), this.getServiceName(),
                this.getUsableArea(), this.getRentalCosts(),
                this.getMaximumNumberOfPeople(), this.getRentalType(), roomStandard, poolArea,
                numberOfFloors);
    }
}
