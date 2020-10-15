package org.sid.service;

import org.sid.entities.Etudiant;
import org.sid.entities.Professeur;

public interface ProfesseurService {
    public Professeur saveProfesseur(Professeur professeur);
    public Professeur loadProfesseurByUsername(String username);
    public Professeur updateProfesseur(Professeur professeur);
    public void deleteProfesseur(String username);
}
