package com.microservice.platform.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformSearchEventRepository extends JpaRepository<PlatformSearchEvent, Integer> {
}
