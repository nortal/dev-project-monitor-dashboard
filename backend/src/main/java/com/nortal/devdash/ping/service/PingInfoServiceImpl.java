package com.nortal.devdash.ping.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nortal.devdash.ping.dao.PingInfoRepository;
import com.nortal.devdash.ping.model.PingInfo;

@Service
public class PingInfoServiceImpl implements PingInfoService {

    @Autowired
    private PingInfoRepository pingInfoRepository;

    @Override
    public List<PingInfo> getAll() {
        return StreamSupport.stream(pingInfoRepository.findAll().spliterator(), Boolean.FALSE)
                .collect(Collectors.toList());
    }
}
