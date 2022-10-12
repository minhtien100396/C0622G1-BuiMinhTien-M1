package case_study.task_1.models;

public class Contract {
    private String idContract;
    private String idBooking;
    private double deposit;
    private double totalPayment;
    private String idCustomer;

    public Contract() {
    }

    public Contract(String idContract, String idBooking, double deposit, double totalPayment, String idCustomer) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.idCustomer = idCustomer;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
//        return "Contract{" +
//                "idContract='" + idContract + '\'' +
//                ", idBooking='" + idBooking + '\'' +
//                ", deposit=" + deposit +
//                ", totalPayment=" + totalPayment +
//                ", idCustomer='" + idCustomer + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s",this.idContract,this.idBooking,this.deposit,this.totalPayment,this.idCustomer);
    }
}
