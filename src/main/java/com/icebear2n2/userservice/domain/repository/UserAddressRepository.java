package com.icebear2n2.userservice.domain.repository;

import com.icebear2n2.userservice.domain.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
