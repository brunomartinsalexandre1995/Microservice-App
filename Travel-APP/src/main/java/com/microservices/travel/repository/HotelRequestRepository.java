package com.microservices.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRequestRepository extends JpaRepository<HotelRequest, Integer> {
}
