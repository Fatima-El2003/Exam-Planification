package com.ensah.examplan.controller;

import com.ensah.examplan.model.Admin;
import com.ensah.examplan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("http://localhost:3000/")

public class AdminController {

    @Autowired
    private AdminService adminService;
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome this endpoint is not secure";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        Admin savedAdmin = adminService.addAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }
    @GetMapping("{idAdmin}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Admin> getAdminById(@PathVariable("idAdmin") Long id){
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
    @GetMapping("/nullSalle")
    public ResponseEntity<Admin> getAdminsBySalleIdNULL(LocalTime heureDebutExam, LocalTime heureFinExam){
        Admin admins = adminService.getAdminsBySalleIdNULL( heureDebutExam,  heureFinExam);
        return ResponseEntity.ok(admins);
    }
    @PutMapping("{idAdmin}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("idAdmin") Long id,@RequestBody Admin updatedAdmin){
        Admin admin = adminService.updateAdmin(id, updatedAdmin);
        return ResponseEntity.ok(admin);
    }
    @DeleteMapping("{idAdmin}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable("idAdmin") Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Personnel deleted successfully");
    }
}
