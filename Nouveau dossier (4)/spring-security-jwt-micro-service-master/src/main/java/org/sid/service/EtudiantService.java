package org.sid.service;

import org.sid.entities.AppUser;
import org.sid.entities.Etudiant;
import org.sid.web.UserForm;


public interface EtudiantService {
    public Etudiant saveEtudiant(UserForm userForm);
    public Etudiant loadEtudiantByUsername(String username);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiant(String username);
}
