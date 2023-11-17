package hutech.nguyenthanhthuan.Library.service;

import hutech.nguyenthanhthuan.Library.dto.CustomerDto;
import hutech.nguyenthanhthuan.Library.model.Customer;

public interface CustomerService {
    Customer save(CustomerDto customerDto);

    Customer findByUsername(String username);

    Customer update(CustomerDto customerDto);

    Customer changePass(CustomerDto customerDto);

    CustomerDto getCustomer(String username);
}
