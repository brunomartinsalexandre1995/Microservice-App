package com.microservices.hotels.repository;

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
public class HotelSuggestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column
    String geoId;

    @Column
    String destinationId;

    @Column
    String landmarkCityDestinationId;

    @Column
    String type;

    @Column
    String caption;

    @Column
    String redirectPage;

    @Column
    String latitude;

    @Column
    String longitude;

    @Column
    String name;


}
