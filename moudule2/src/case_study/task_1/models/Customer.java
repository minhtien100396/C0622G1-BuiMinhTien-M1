package case_study.task_1.models;

import java.time.LocalDate;

public class Customer extends Person {
    private String idCustomer;
    private String customerType;
    private String addressCustomer;

    public Customer() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getName(), this.getDateOfBirth(), this.getGender(), this.getIdCard(), this.getPhoneNumber(),
                this.getEmail(), idCustomer, customerType, addressCustomer);
    }

    public Customer(String idCustomer, String customerType, String addressCustom) {
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.addressCustomer = addressCustom;
    }

    public Customer(String name, LocalDate dateOfBirth, String gender, String idCard, String phoneNumber,
                    String email, String idCustomer, String customerType, String addressCustom) {
        super(name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.addressCustomer = addressCustom;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public String toString() {
//        return "Customer{" +
//                "IdCustomer='" + IdCustomer + '\'' +
//                ", customerType='" + customerType + '\'' +
//                ", addressCustom='" + addressCustom + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getName(), this.getDateOfBirth(), this.getGender(), this.getIdCard(), this.getPhoneNumber(),
                this.getEmail(), idCustomer, customerType, addressCustomer);
    }
}
