package tech.wvs.desafionubank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.wvs.desafionubank.controller.dto.ContactDto;
import tech.wvs.desafionubank.service.CustomerService;

@RestController
@RequestMapping(path = "/contatos")
public class ContactController {

    private final CustomerService customerService;

    public ContactController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/{clientId}")
    public ResponseEntity<Void> createContact(@PathVariable Long clientId,
                                              @RequestBody ContactDto dto) {
        var contact = customerService.addContact(clientId, dto);

        return ResponseEntity.ok().build();
    }
}
