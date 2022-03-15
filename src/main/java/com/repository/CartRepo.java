package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	Cart findByorders(String orders);

	@Query("Select c from Cart c where c.quantity=?1 order by c.orders")
	List<Cart> findByTechSorted(String quantity);
}
