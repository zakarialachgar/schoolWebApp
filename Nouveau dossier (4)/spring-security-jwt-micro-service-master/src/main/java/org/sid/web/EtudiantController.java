package org.sid.web;

import org.sid.entities.Etudiant;

import org.sid.service.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EtudiantController {

    @Autowired
    EtudiantServiceImpl etudiantServiceImpl;

    @PostMapping("/etudiant/register")
    public Etudiant save(@RequestBody UserForm userForm){
        return etudiantServiceImpl.saveEtudiant(userForm);
    }
    @PutMapping("/etudiant/update")
    public Etudiant update(@RequestBody Etudiant etudiant){
        return etudiantServiceImpl.updateEtudiant(etudiant);
    }
    @DeleteMapping("/etudiant/delete/{username}")
    public  void delete(@PathVariable String username){
         etudiantServiceImpl.deleteEtudiant(username);
    }

}
