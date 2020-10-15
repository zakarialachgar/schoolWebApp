package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Professeur extends AppUser {
    private String code;
    private String firstname;
    private String lastname;
    private String matriere;
    private String email;
    private String num;
}
