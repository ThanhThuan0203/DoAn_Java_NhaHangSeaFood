package hutech.nguyenthanhthuan.Library.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 10, message = "Tên chứa 3-10 ký tự")
    private String firstName;
    @Size(min = 3, max = 10, message = "Họ chứa 3-10 ký tự")
    private String lastName;
    private String username;
    @Size(min = 5, max = 10, message = "Mật khẩu chứa 5-10 ký tự")
    private String password;
    private String repeatPassword;
}
