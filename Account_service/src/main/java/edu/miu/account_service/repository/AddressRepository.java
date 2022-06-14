package edu.miu.account_service.repository;

import edu.miu.account_service.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
