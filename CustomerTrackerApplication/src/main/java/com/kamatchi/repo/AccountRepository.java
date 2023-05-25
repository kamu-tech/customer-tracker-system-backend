package com.kamatchi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kamatchi.model.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query(nativeQuery=true,value="SELECT * FROM springboot.account ea join springboot.customer e on e.id=ea.customer_id where customer_id=:id")
	List<Account> findAccountById(@Param("id") int id);
}
