package com.build.services.impl;

import com.build.entity.Admin;
import com.build.exceptions.ResourceNotFoundException;
import com.build.payloads.AdminDto;
import com.build.repositories.AdminRepo;
import com.build.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin adm = this.modelMapper.map(adminDto, Admin.class);

        Admin addAdm = this.adminRepo.save(adm);

        return this.modelMapper.map(addAdm, AdminDto.class);
    }

    @Override
    public AdminDto updateAdmin(AdminDto admin, Integer adminId) {
        Admin adm = this.adminRepo.findById(adminId)
                .orElseThrow(()-> new ResourceNotFoundException("Admin", "AdminId", adminId));
        adm.setAdminName(admin.getAdminName());
        adm.setAdminPassword(admin.getAdminPassword());

        Admin savedAdm = this.adminRepo.save(adm);

        return this.modelMapper.map(savedAdm, AdminDto.class);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        Admin adm = this.adminRepo.findById(adminId)
                .orElseThrow(()-> new ResourceNotFoundException("Admin", "adminId", adminId));
        this.adminRepo.delete(adm);
    }

//    @Override
//    public List<AdminDto> getAllAdmin() {
//        return null;
//    }
//
//    @Override
//    public AdminDto getAdminById(Integer userId) {
//        return null;
//    }
}
