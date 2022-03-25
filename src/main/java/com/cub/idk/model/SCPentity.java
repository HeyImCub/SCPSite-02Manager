package com.cub.idk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "SCPEntities")
public class SCPentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IdNum")
    private int IdNum;

    @Column(name = "Nickname")
    private String Nickname;

    @Column(name= "Classification")
    private String Classification;
}
