package org.sid.dao;

import org.sid.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    public Professeur findByUsername(String username);
}
