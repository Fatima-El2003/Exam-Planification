package com.ensah.examplan.service;

import com.ensah.examplan.model.Admin;

import java.util.List;

public interface AdminService {
    Admin addAdmin(Admin admin);
    Admin getAdminById(Long idAdmin);
    List<Admin> getAllAdmins();
    Admin updateAdmin(Long idAdmin, Admin updatedAdmin);
    void deleteAdmin(Long idAdmin);
    List<Admin> getAdminsBySalleIdNULL();

}
