package org.sid.dao;

import org.sid.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    public Etudiant findByCne(String cne);
    public Etudiant findByUsername(String username);
}
