package com.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Customer;
import com.entity.Orders;


@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
Customer findByOname(String oname);
	
	@Query("Select o from Orders o where o.items=?1 order by o.oname")
	List<Orders> findByItemsSorted(String items);
}
