package com.motomania.library.service;

import com.motomania.library.domain.CustomerEntity;
import com.motomania.library.dto.Customer;
import com.motomania.library.repo.CustomerRepo;
import com.motomania.library.util.MapperUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final MapperUtil mapperUtil;

    public CustomerService(CustomerRepo customerRepo, MapperUtil mapperUtil) {
        this.customerRepo = customerRepo;
        this.mapperUtil = mapperUtil;
    }

    public Customer getCustomer(Long id) {
        CustomerEntity customerEntity = customerRepo
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No customer found with id = " + id));

        return mapperUtil.map(customerEntity, Customer.class);
    }

    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customerEntityList = customerRepo.findAll();

        return mapperUtil.mapList(customerEntityList, Customer.class);
    }

    public List<Customer> getAllCustomersByLibraryId(Long libraryId) {
        List<CustomerEntity> customerEntityList = customerRepo.findAllByLibraryId(libraryId);

        return mapperUtil.mapList(customerEntityList, Customer.class);
    }

    public Customer createCustomer(Customer customer) {
        CustomerEntity savedCustomer = customerRepo.save(
                mapperUtil.map(customer, CustomerEntity.class));

        return mapperUtil.map(savedCustomer, Customer.class);
    }

    public Customer updateCustomer(Customer customer) {
        CustomerEntity savedCustomer = customerRepo.save(
                mapperUtil.map(customer, CustomerEntity.class));

        return mapperUtil.map(savedCustomer, Customer.class);
    }

    public void deleteCustomer(Long id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        }
    }
}
