package com.ensah.examplan.service;

import com.ensah.examplan.model.Admin;

<<<<<<< HEAD
=======
import java.time.LocalTime;
>>>>>>> origin/master
import java.util.List;

public interface AdminService {
    Admin addAdmin(Admin admin);
    Admin getAdminById(Long idAdmin);
    List<Admin> getAllAdmins();
    Admin updateAdmin(Long idAdmin, Admin updatedAdmin);
    void deleteAdmin(Long idAdmin);
<<<<<<< HEAD
=======
    Admin getAdminsBySalleIdNULL(LocalTime heureDebutExam, LocalTime heureFinExam);

>>>>>>> origin/master
}
