package com.nortal.devdash.ping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortal.devdash.ping.model.PingInfo;
import com.nortal.devdash.ping.model.PingStatus;

public interface PingInfoRepository extends JpaRepository<PingInfo, Long> {

    List<PingInfo> findByStatus(PingStatus status);

    // Could we manage to make all queries through JpaRepository alone? That would be fun...
    // It is also possible to skip Spring Data JPA altogether and inject entityManager, usual stuff.
}
