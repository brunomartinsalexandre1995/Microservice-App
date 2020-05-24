package com.microservices.hotels.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class HotelRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "SEARCH_WORD", unique = true, nullable = false, length = 100)
    private String searchWord;

    @JsonProperty("moresuggestions")
    String moresuggestions;

    @JsonProperty("autoSuggestInstance")
    String autoSuggestInstance;

    @JsonProperty("trackingID")
    String trackingID;

    @JsonProperty("misspellingfallback")
    Boolean misspellingfallback;

    @OneToMany(cascade = CascadeType.ALL)
    List<HotelSuggestion> suggestions;


}
