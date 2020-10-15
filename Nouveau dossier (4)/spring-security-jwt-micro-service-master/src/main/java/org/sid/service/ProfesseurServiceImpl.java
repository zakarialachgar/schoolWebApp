package org.sid.service;

import org.sid.dao.AppUserRepository;
import org.sid.dao.ProfesseurRepository;
import org.sid.dao.ProfesseurRepository;
import org.sid.entities.AppUser;
import org.sid.entities.Etudiant;
import org.sid.entities.Professeur;
import org.sid.entities.Professeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfesseurServiceImpl implements ProfesseurService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    AccountService accountService;

    @Override
    public Professeur saveProfesseur(Professeur professeur) {
        Professeur prof = professeurRepository.findByUsername(professeur.getUsername());
        if(prof==null) throw new RuntimeException("user already exist");
        Professeur p = new Professeur();
        p.setCode(professeur.getCode());
        p.setFirstname(professeur.getFirstname());
        p.setLastname(professeur.getLastname());
        p.setEmail(professeur.getEmail());
        p.setNum(professeur.getNum());
        p.setMatriere(professeur.getMatriere());
        professeurRepository.save(p);
        AppUser appUser= appUserRepository.user((p.getId()));
        appUser.setUsername(professeur.getUsername());
        appUser.setActive(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(professeur.getPassword()));
        appUserRepository.save(appUser);
        accountService.addRoleToUser(professeur.getUsername(),"PROFESSEUR");
        return p;
    }

    @Override
    public Professeur loadProfesseurByUsername(String username) {
        Professeur professeur = professeurRepository.findByUsername(username);
        if(professeur==null) throw  new RuntimeException("user dont exist");
        return professeur;
    }

    @Override
    public Professeur updateProfesseur(Professeur professeur) {
        Professeur p= professeurRepository.findByUsername(professeur.getUsername());
        if(p==null) throw new RuntimeException("User dont exists");
        p.setNum(professeur.getNum());
        p.setEmail(professeur.getEmail());
        p.setFirstname(professeur.getFirstname());
        p.setFirstname(professeur.getFirstname());
        p.setCode(p.getCode());
        p.setMatriere(professeur.getMatriere());
        return p;
    }

    @Override
    public void deleteProfesseur(String username) {
       Professeur professeur= professeurRepository.findByUsername(username);
        professeurRepository.delete(professeur);

    }
}
