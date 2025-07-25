package tech.wvs.desafionubank.service;

import org.springframework.stereotype.Service;
import tech.wvs.desafionubank.controller.dto.ContactDto;
import tech.wvs.desafionubank.controller.dto.CustomerDto;
import tech.wvs.desafionubank.domain.Contact;
import tech.wvs.desafionubank.domain.Customer;
import tech.wvs.desafionubank.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDto dto) {
        var entity = new Customer(dto);
        return customerRepository.save(entity);
    }

    public Customer findById(Long clientId) {
        return customerRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Customer addContact(Long clientId, ContactDto contactDto) {
        var customer = findById(clientId);

        customer.getContacts().add(new Contact(contactDto));

        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Contact> findAllContacts(Long clientId) {
        var customer = customerRepository.findById(clientId);

        return customer.get().getContacts()
                .stream()
                .map(c -> new Contact(c.getId(), c.getName(), c.getPhoneNumber(), c.getEmail()))
                .collect(Collectors.toList());
    }
}
