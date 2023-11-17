package hutech.nguyenthanhthuan.Library.service;

import hutech.nguyenthanhthuan.Library.dto.AdminDto;
import hutech.nguyenthanhthuan.Library.model.Admin;

public interface AdminService {
    Admin save(AdminDto adminDto);

    Admin findByUsername(String username);
}