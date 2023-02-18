package com.selacha.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selacha.start.domain.Address;



public interface AddressRepo extends JpaRepository<Address,Long> {

}
