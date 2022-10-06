package repository.impl;

import repository.IContractRepository;
import repository.ICustomerRepository;
import repository.IEmployeeRepository;
import repository.IServiceRepository;

public class test {
    public static void main(String[] args) {
        IEmployeeRepository repo = new EmployeeRepository();
        ICustomerRepository customerRepository = new CustomerRepository();
        IContractRepository contractRepository = new ContractRepository();
        IServiceRepository serviceRepository = new ServiceRepository();
//        System.out.println("Kich thuoc: " + repo.selectAllEmployee().size());
//        System.out.println("Customer: "+ customerRepository.selectAllCustomer().size());
//        System.out.println("Contract: "+ contractRepository.selectAllContract().size());
        System.out.println("Service: "+ serviceRepository.selectAllService().size());
        System.out.println("Service: "+ repo.selectEmployee("a"));
        System.out.println("Position: "+ repo.selectAllPosition());
    }
}
