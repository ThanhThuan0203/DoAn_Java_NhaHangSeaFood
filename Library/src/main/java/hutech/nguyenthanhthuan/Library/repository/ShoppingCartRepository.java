package hutech.nguyenthanhthuan.Library.repository;

import hutech.nguyenthanhthuan.Library.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
