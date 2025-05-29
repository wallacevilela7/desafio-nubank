package tech.wvs.desafionubank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.wvs.desafionubank.controller.dto.CustomerDto;
import tech.wvs.desafionubank.domain.Contact;
import tech.wvs.desafionubank.domain.Customer;
import tech.wvs.desafionubank.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto dto) {
        var customer = customerService.createCustomer(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        var customers = customerService.findAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(path = "/{clientId}/contatos")
    public ResponseEntity<List<Contact>> findAllContacts(@PathVariable Long clientId) {
       // return customerService.findAllContacts(clientId);
        var contacts = customerService.findAllContacts(clientId);
        return ResponseEntity.ok(contacts);
    }
}
