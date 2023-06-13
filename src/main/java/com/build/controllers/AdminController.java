package com.build.controllers;

import com.build.payloads.AdminDto;
import com.build.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //create
    @PostMapping("/")
    public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto adminDto)
    {
        AdminDto adminDto1 = this.adminService.createAdmin(adminDto);

        return new ResponseEntity<>(adminDto1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AdminDto>> getAll(@RequestBody AdminDto adminDto)
    {
        return ResponseEntity.ok(this.adminService.getAdmin());
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<AdminDto> updateAdmin(@Valid @RequestBody AdminDto adminDto, @PathVariable("adminId") Integer aId)
    {
        AdminDto updatedAdmin = this.adminService.updateAdmin(adminDto, aId);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteAdmin(@Valid @PathVariable("adminId") Integer aId)
    {
        this.adminService.deleteAdmin(aId);

        return new ResponseEntity<>(Map.of("Message", "Admin deleted successfully"), HttpStatus.OK);
    }
}
