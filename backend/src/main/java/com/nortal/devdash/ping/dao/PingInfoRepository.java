package com.nortal.devdash.ping.dao;

import org.springframework.data.repository.CrudRepository;

import com.nortal.devdash.ping.model.PingInfo;

public interface PingInfoRepository extends CrudRepository<PingInfo, Long> {

}
