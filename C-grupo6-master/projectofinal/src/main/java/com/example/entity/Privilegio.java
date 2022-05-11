package com.example.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Component
public class Privilegio {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=”pessoa_sequence”)
    //@SequenceGenerator(name=”pessoa_sequence”, sequenceName=”pes_seq”)

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

}
