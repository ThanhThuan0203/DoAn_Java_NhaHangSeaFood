package hutech.nguyenthanhthuan.Library.repository;

import hutech.nguyenthanhthuan.Library.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
