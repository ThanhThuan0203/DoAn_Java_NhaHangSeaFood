package hutech.nguyenthanhthuan.Library.dto;
import hutech.nguyenthanhthuan.Library.model.City;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @Size(min = 3, max = 10, message = "Tên chứa 3-10 ký tự")
    private String firstName;

    @Size(min = 3, max = 10, message = "Họ chứa 3-10 ký tự")
    private String lastName;
    private String username;
    @Size(min = 3, max = 15, message = "Mật khẩu chứa 3-10 ký tự")
    private String password;

    @Size(min = 10, max = 15, message = "Số điện thoại chứa 10-15 ký tự")
    private String phoneNumber;

    private String address;
    private String confirmPassword;
    private City city;
    private String image;
    private String country;

}
