package hutech.nguyenthanhthuan.Customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"hutech.nguyenthanhthuan.Library.*", "hutech.nguyenthanhthuan.Customer.*"})
@EnableJpaRepositories(value = "hutech.nguyenthanhthuan.Library.repository")
@EntityScan(value = "hutech.nguyenthanhthuan.Library.model")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
