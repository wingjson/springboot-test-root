package com.zja.service;

import com.zja.dao.duke.DukeUserDao;
import com.zja.dao.gxtz.GxtzUserDao;
import com.zja.entity.duke.DukeUserEntity;
import com.zja.entity.gxtz.GxtzUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengja@dist.com.cn
 * @data 2019/7/9 10:44
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    DukeUserDao dukeUserDao;

    @Autowired
    GxtzUserDao gxtzUserDao;

    @Override
    public List<DukeUserEntity> getAllDukeUser(){
        return dukeUserDao.findAll();
    }

    @Override
    public List<GxtzUserEntity> getAllGxtzUser(){
        return gxtzUserDao.findAll();
    }

    @Override
    public DukeUserEntity saveDukeUser(DukeUserEntity dukeUserEntity){
        return dukeUserDao.save(dukeUserEntity);
    }

    @Override
    public GxtzUserEntity saveGxtzUser(GxtzUserEntity gxtzUserEntity){
        return gxtzUserDao.save(gxtzUserEntity);
    }
}