package tech.wvs.desafionubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.desafionubank.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
