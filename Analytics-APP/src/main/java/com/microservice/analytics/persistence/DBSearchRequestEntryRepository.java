package com.microservice.analytics.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DBSearchRequestEntryRepository extends JpaRepository<DBSearchRequestEntry, Integer> {
}
