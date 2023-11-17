package hutech.nguyenthanhthuan.Admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"hutech.nguyenthanhthuan.Library.*", "hutech.nguyenthanhthuan.Admin.*"})
@EnableJpaRepositories(value = "hutech.nguyenthanhthuan.Library.repository")
@EntityScan(value = "hutech.nguyenthanhthuan.Library.model")
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
