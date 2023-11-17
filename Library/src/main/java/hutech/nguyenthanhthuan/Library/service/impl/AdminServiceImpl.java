package hutech.nguyenthanhthuan.Library.service.impl;

import hutech.nguyenthanhthuan.Library.dto.AdminDto;
import hutech.nguyenthanhthuan.Library.model.Admin;
import hutech.nguyenthanhthuan.Library.repository.AdminRepository;
import hutech.nguyenthanhthuan.Library.repository.RoleRepository;
import hutech.nguyenthanhthuan.Library.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;


    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}