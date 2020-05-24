package com.movieApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMDBRequestRepository extends JpaRepository<IMDBRequest, Integer> {
}
