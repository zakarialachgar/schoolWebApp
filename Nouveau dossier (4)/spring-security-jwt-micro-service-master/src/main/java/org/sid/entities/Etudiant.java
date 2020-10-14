package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Etudiant {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @Column(unique = true)
    private String cne;
    @OneToOne(fetch = FetchType.EAGER)
    private AppUser appUser;
//    private String firstname;
//    private String lastname;
//    private String email;
//    private String num;
//    private String numP;


}
