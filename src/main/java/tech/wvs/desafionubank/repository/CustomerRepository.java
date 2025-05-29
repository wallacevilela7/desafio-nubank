package tech.wvs.desafionubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.desafionubank.domain.Contact;
import tech.wvs.desafionubank.domain.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Contact> findContactsById(Long clientId);
}
