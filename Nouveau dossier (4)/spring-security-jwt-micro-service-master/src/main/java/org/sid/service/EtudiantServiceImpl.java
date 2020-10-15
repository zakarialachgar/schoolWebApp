package org.sid.service;

import jdk.internal.dynalink.support.NameCodec;
import org.sid.dao.AppUserRepository;
import org.sid.dao.EtudiantRepository;
import org.sid.entities.AppUser;
import org.sid.entities.Etudiant;
import org.sid.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EtudiantServiceImpl  implements EtudiantService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    AccountService accountService;

    @Override
    public Etudiant saveEtudiant(UserForm userForm) {
        if(!userForm.getPassword().equals(userForm.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");
        Etudiant etudiant= etudiantRepository.findByUsername(userForm.getUsername());
        if(etudiant!=null) throw new RuntimeException("User already exists");
        Etudiant e = new Etudiant();

        etudiantRepository.save(e);
         accountService.saveUser(e.getId(),userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
        accountService.addRoleToUser(userForm.getUsername(),"ETUDIANT");

        return e;
    }


//    @Override
//    public Etudiant saveEtudiant(Etudiant   etudiant) {
//        if(!etudiant.getPassword().equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
//        Etudiant e = new Etudiant();
//        e.setCne(etudiant.getCne());
//        e.setFirstname(etudiant.getFirstname());
//        e.setLastname(etudiant.getLastname());
//        e.setEmail(etudiant.getEmail());
//        e.setNum(etudiant.getNum());
//        e.setNumP(etudiant.getNumP());
//        e.setFiliere(etudiant.getFiliere());
//        etudiantRepository.save(e);
//        AppUser appUser= appUserRepository.user((e.getId()));
//        appUser.setUsername(etudiant.getUsername());
//        appUser.setActive(true);
//        appUser.setPassword(bCryptPasswordEncoder.encode(etudiant.getPassword()));
//        appUserRepository.save(appUser);
//        accountService.addRoleToUser(etudiant.getUsername(),"ETUDIANT");
//
//        return e;
//    }
    @Override
    public Etudiant loadEtudiantByUsername(String username){
        Etudiant etudiant = etudiantRepository.findByUsername(username);
        if(etudiant==null) throw  new RuntimeException("user dont exist");
        return etudiant;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant){
        Etudiant e=etudiantRepository.findByUsername(etudiant.getUsername());
        if(e==null) throw new RuntimeException("User dont exists");
        e.setNumP(etudiant.getNumP());
        e.setNum(etudiant.getNum());
        e.setEmail(etudiant.getEmail());
        e.setFirstname(etudiant.getFirstname());
        e.setLastname(etudiant.getLastname());
        e.setFiliere(etudiant.getFiliere());
        e.setCne(etudiant.getCne());
        return e;
    }

    @Override
    public void deleteEtudiant(String username){
        Etudiant etudiant= etudiantRepository.findByUsername(username);
        etudiantRepository.delete(etudiant);
    }



}
