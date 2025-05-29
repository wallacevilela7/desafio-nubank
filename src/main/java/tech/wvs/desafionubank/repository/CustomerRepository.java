package tech.wvs.desafionubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.desafionubank.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
