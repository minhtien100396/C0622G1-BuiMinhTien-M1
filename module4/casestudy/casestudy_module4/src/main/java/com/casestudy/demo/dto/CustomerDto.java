package com.casestudy.demo.dto;

import com.casestudy.demo.model.Contract;
import com.casestudy.demo.model.CustomerType;
import com.casestudy.demo.model.Gender;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

public class CustomerDto implements Validator {
    private Integer id;
    @NotBlank(message = "Name cannot be left blank")
    private String name;
    @NotBlank
    private String dateOfBirth;
    @NotBlank(message = "Id Card cannot be left blank")
    private String idCard;
    @NotBlank(message = "Phone Number cannot be left blank")
    private String phoneNumber;
    @NotBlank(message = "Email cannot be left blank")
    private String email;
    @NotBlank(message = "Address cannot be left blank")
    private String address;
    private Integer status = 1;
    private Gender gender;
    private CustomerType customerType;
    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.name.matches("^[A-ZÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ](?:'[A-ZÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ])*[a-zàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹý]*(?: [A-ZÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ](?:'[A-ZÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ])*[a-zàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹý]*)*$")) {
            errors.rejectValue("name", "name.errors", "The customer name cannot contain numbers. And the first letter of each word must be capitalized.");
        }
        if (!customerDto.phoneNumber.matches("^09[0|1][0-9]{7}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.errors", "The phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.");
        }
        if (!customerDto.idCard.matches("^[0-9]{9}$")) {
            errors.rejectValue("idCard", "idCard.errors", "The Id Card must be in the correct format XXXXXXXXX or XXXXXXXXXXXX (X is the number 0-9).");
        }
        if (!customerDto.email.matches("^[(a-zA-Z0-9-\\_\\.!\\D)]+@[(a-zA-Z)]+\\.[(a-zA-Z)]{2,3}$")) {
            errors.rejectValue("email", "email.errors", "Email address must be in the correct format");
        }
        if (!customerDto.address.matches("^[A-Za-z0-9àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ[,/] ]{2,45}$")) {
            errors.rejectValue("address", "address.errors", "Address must be in the correct format");
        }

        if (("").equals(customerDto.getDateOfBirth())) {
            errors.rejectValue("dateOfBirth", "birthDate.errors", "Date Of Birth not null");
        } else {
            int age = LocalDate.now().getYear() - LocalDate.parse(customerDto.dateOfBirth).getYear();
            if (age < 18 || age > 100) {
                errors.rejectValue("dateOfBirth", "dateOfBirth.errors", "Date Of Birth must be in the correct format (age < 18 || age > 100)");
            }
        }
    }
}
