package com.nortal.devdash.ping.dao;

import java.util.Collections;

import org.springframework.stereotype.Repository;

import com.nortal.devdash.ping.model.PingInfo;

@Repository
public class PingInfoRepositoryImpl implements PingInfoRepository {

    @Override
    public <S extends PingInfo> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends PingInfo> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PingInfo findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<PingInfo> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Iterable<PingInfo> findAll(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(PingInfo entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Iterable<? extends PingInfo> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

}
