package com.movieApp.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IMDBRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "SEARCH_WORD", unique = true, nullable = false, length = 100)
    private String searchWord;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IMDBMovie> movies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<IMDBName> names = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<IMDBCompany> companies = new ArrayList<>();

}
