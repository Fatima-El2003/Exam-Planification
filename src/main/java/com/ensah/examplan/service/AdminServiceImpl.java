package com.ensah.examplan.service;

import com.ensah.examplan.exception.ResourceNotFoundException;
import com.ensah.examplan.model.Admin;
import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.time.LocalTime;
>>>>>>> origin/master
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long idAdmin) {
        return adminRepository.findById(idAdmin).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" +idAdmin ));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Long idAdmin, Admin updatedAdmin) {
        Admin admin = getAdminById(idAdmin);
        admin.setNom(updatedAdmin.getNom());
        admin.setPrenom(updatedAdmin.getPrenom());
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long idAdmin) {
        adminRepository.deleteById(idAdmin);
    }

<<<<<<< HEAD
=======
    @Override
    public Admin getAdminsBySalleIdNULL(LocalTime heureDebutExam, LocalTime heureFinExam) {
        return adminRepository.findAdminByIdSalleNull(heureDebutExam, heureFinExam);
    }

>>>>>>> origin/master
}
