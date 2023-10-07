package com.mkyong;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends CrudRepository<ContactInfo,Integer> {
	 List<ContactInfo> findByUsername(String username);
	 List<ContactInfo> deleteByUsername(String username);
	 Optional<ContactInfo> findByMobno(String mobno);
}
