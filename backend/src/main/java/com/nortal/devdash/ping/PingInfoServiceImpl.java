package com.nortal.devdash.ping;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortal.devdash.ping.model.PingInfo;

@Service
class PingInfoServiceImpl implements PingInfoService {

    private PingInfoRepository pingInfoRepository;

    public PingInfoServiceImpl(PingInfoRepository pingInfoRepository) {
        this.pingInfoRepository = pingInfoRepository;
    }

    @Override
    public List<PingInfo> getAll() {
        return pingInfoRepository.findAll();
    }
}
