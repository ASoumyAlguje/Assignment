package com.build.services;

import com.build.entity.Admin;
import com.build.payloads.AdminDto;

import java.util.List;

public interface AdminService {

    //Create
    AdminDto createAdmin(AdminDto adminDto);

    //update
    AdminDto updateAdmin(AdminDto admin, Integer adminId);

    //delete
    void deleteAdmin(Integer adminId);

    //getAll
//    List<AdminDto> getAllAdmin();
//
//    //get
//    AdminDto getAdminById(Integer userId);
}
