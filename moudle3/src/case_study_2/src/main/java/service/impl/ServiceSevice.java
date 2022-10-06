package service.impl;

import model.Service;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ServiceSevice implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public Service selectService(int id) {
        return serviceRepository.selectService(id);
    }

    @Override
    public List<Service> selectService(String keyName) {
        return serviceRepository.selectService(keyName);
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return serviceRepository.deleteService(id);
    }

    @Override
    public Map<Integer, String> selectAllRentType() {
        return serviceRepository.selectAllRentType();
    }

    @Override
    public Map<Integer, String> selectAllFacilityType() {
        return serviceRepository.selectAllFacilityType();
    }
}
