package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRepository;
import peaksoft.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new NullPointerException("Customer with id: "+id+" is not found!"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer customer1 = customerRepository.findById(id).
                orElseThrow(()-> new NullPointerException
                        ("Customer with id: "+id+" is not found!"));
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setGender(customer.getGender());
        customer1.setSurName(customer.getSurName());
        customer1.setDateOfBirth(customer.getDateOfBirth());
        customerRepository.save(customer1);
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
        else throw new NullPointerException("Customer with id: " + id + " is not found");
    }
}
