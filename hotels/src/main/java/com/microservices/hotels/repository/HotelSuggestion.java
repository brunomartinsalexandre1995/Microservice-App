package com.microservices.hotels.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.hotels.dto.HotelSearchSuggestionEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelSuggestion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column
    String suggestionGroup;

    @OneToMany(cascade = CascadeType.ALL)
    List<HotelSuggestionEntity> entities;


}
