package com.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Bill;
public interface BillRepo extends JpaRepository<Bill, Integer> {
	Bill findBycustomerName(String customerName);
	
	@Query("Select b from Bill b where b.vegetables=?1 order by b.customerName")
	List<Bill> findByvegetablesSorted(String vegetables);
}
