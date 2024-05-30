package com.ensah.examplan.service;

<<<<<<< HEAD
import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
=======
import com.ensah.examplan.model.*;
import com.ensah.examplan.repository.AdminRepository;
>>>>>>> origin/master
import com.ensah.examplan.repository.ExamenRepository;
import com.ensah.examplan.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.time.Duration;
import java.time.LocalTime;
>>>>>>> origin/master
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImpl implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private SalleRepository salleRepository;
<<<<<<< HEAD

=======
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;
>>>>>>> origin/master
    @Autowired
    private EnseignantService enseignantService;

    @Override
    public Examen addExamen(Examen examen, Set<Salle> salles, MultipartFile epreuveFile, MultipartFile pvFile, Long idGroupe) {
        try {
            if (epreuveFile != null && !epreuveFile.isEmpty()) {
                examen.setEpreuve(epreuveFile.getBytes());
            }
            if (pvFile != null && !pvFile.isEmpty()) {
                examen.setPv(pvFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store file data", e);
        }

        Examen savedExamen = examenRepository.save(examen);

        for (Salle salle : salles) {
            System.out.println(salle.getIdSalle());
<<<<<<< HEAD
            Salle salle1=salleRepository.findById(salle.getIdSalle()).get();
=======

            Salle salle1 = salleRepository.findById(salle.getIdSalle()).get();
>>>>>>> origin/master
            salle1.setIdSalle(salle.getIdSalle());
            salle1.setNom(salle.getNom());
            salle1.setSurveillantCount(salle.getSurveillantCount());
            salle1.setExamen(savedExamen);
<<<<<<< HEAD
            salleRepository.save(salle1);

        }
        affecterSurveillants(idGroupe, salles);
=======

            // Get the admin
//            Admin admin = adminService.getAdminById(salle.getAdmin().getIdPersonnel());
//
//            // Check if admin is new and needs to be saved
//            if (admin == null) {
//                admin = salle.getAdmin();
//                adminService.addAdmin(admin);  // Ensure admin is saved first
//            }
//
//            // Set admin to salle1
//            salle1.setAdmin(admin);

            // Save the updated salle
            salleRepository.save(salle1);

            // Update the admin with the salle ID
       //     admin.setIdSalle(salle.getIdSalle());
          //  adminService.updateAdmin(admin.getIdPersonnel(), admin);
        }
        affecterAdmins(salles,examen.getHeureDebut(),examen.getHeureDebut().plus(Duration.ofMinutes((long) (examen.getDureePrevue() * 60))));
        affecterSurveillants(idGroupe, salles,examen.getHeureDebut(),examen.getHeureDebut().plus(Duration.ofMinutes((long) (examen.getDureePrevue() * 60))));
        System.out.println("appel");
>>>>>>> origin/master
        return savedExamen;
    }

    @Override
    public Examen getExamenById(Long idExamen) {
        return examenRepository.findById(idExamen).orElse(null);
    }

    @Override
    public List<Examen> getAllExamens() {
        return examenRepository.findAll();
    }

    @Override
    public Examen updateExamen(Long idExamen, Examen updatedExamen) {
        return examenRepository.findById(idExamen)
                .map(examen -> {
                    examen.setDate(updatedExamen.getDate());
                    examen.setDureePrevue(updatedExamen.getDureePrevue());
                    examen.setDureeRelle(updatedExamen.getDureeRelle());
                    examen.setHeureDebut(updatedExamen.getHeureDebut());
                    examen.setType(updatedExamen.getType());
                    examen.setRapportTextuelle(updatedExamen.getRapportTextuelle());
                    // Update other fields as necessary
                    return examenRepository.save(examen);
                })
                .orElse(null);
    }

    @Override
    public void deleteExamen(Long idExamen) {
        examenRepository.deleteById(idExamen);
    }

    @Override
<<<<<<< HEAD
    public void affecterSurveillants(Long idGroupe, Set<Salle> salles) {
        for (Salle salle : salles) {
            List<Enseignant> surveillants = enseignantService.getSurveillantsByGroupe(idGroupe, salle.getSurveillantCount());
            Long idSalle = salle.getIdSalle();
            for (Enseignant surveillant : surveillants) {
=======
    public void affecterSurveillants(Long idGroupe, Set<Salle> salles,LocalTime heureDebutExam,LocalTime heureFinExam) {
        for (Salle salle : salles) {
            //
            List<Enseignant> surveillants = enseignantService.getSurveillantsByGroupe(idGroupe, salle.getSurveillantCount(), heureDebutExam , heureFinExam);
            System.out.println(surveillants);
            Long idSalle = salle.getIdSalle();
            for (Enseignant surveillant : surveillants){
>>>>>>> origin/master
               surveillant.setIdSalle(idSalle);
               enseignantService.updateEnseignant(surveillant.getIdPersonnel(), surveillant);
            }
        }
    }
<<<<<<< HEAD
=======
    @Override
    public void affecterAdmins(Set<Salle> salles,LocalTime heureDebutExam,LocalTime heureFinExam) {
        for (Salle salle : salles) {
            Salle salle1 = salleRepository.findById(salle.getIdSalle()).get();
            salle1.setIdSalle(salle.getIdSalle());
             Admin admin = adminService.getAdminsBySalleIdNULL(heureDebutExam , heureFinExam);
            Long idSalle = salle.getIdSalle();
            admin.setIdSalle(idSalle);
            salle1.setAdmin(admin);
            salleRepository.save(salle1);
            adminService.updateAdmin(admin.getIdPersonnel(), admin);

        }
    }
>>>>>>> origin/master
}
