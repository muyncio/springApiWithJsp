package com.example.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tabela_testowa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String kolumna1;

    private String kolumna2;

    private String kolumna3;

    private int kolumna4;

    private TestTable(String kolumna1, String kolumna2, String kolumna3, int kolumna4){
        this.kolumna1 = kolumna1;
        this.kolumna2 = kolumna2;
        this.kolumna3 = kolumna3;
        this.kolumna4 = kolumna4;
    }
}
