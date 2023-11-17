package hutech.nguyenthanhthuan.Library.repository;

import hutech.nguyenthanhthuan.Library.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
