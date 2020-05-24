package com.movieApp.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IMDBName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column
    private String title;

    @Column
    private String image;

    @Column
    private String imdbID;

    @ManyToOne
    @JoinColumn(name = "IMDB_REQUEST_ID")
    private IMDBRequest imdbRequest;

}
