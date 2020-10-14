package org.sid.service;

import jdk.internal.dynalink.support.NameCodec;
import org.sid.dao.AppUserRepository;
import org.sid.dao.EtudiantRepository;
import org.sid.entities.AppUser;
import org.sid.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EtudiantImpl  implements EtudiantService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Etudiant saveEtudiant() {
       Etudiant etudiant1 = etudiantRepository.findByCne(etudiant.getCne());
        if( etudiant1 !=null) throw  new RuntimeException("rah kayn");
        Etudiant e = new Etudiant();
        e.setCne(etudiant.getCne());
        AppUser appUser= new AppUser();
        appUser.setUsername();
        etudiantRepository.save(e);
      //  Optional<AppUser> appUser= appUserRepository.findById(e.getId());
        AppUser appUser= appUserRepository.findById();
        e=etudiantRepository.findByCne(etudiant.getCne());
        System.out.println("hello"+e.getPassword());
        return e;
    }
}
