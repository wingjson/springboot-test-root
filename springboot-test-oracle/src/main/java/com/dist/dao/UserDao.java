package com.dist.dao;

import com.dist.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: springbootdemo
 * @Date: 2018/12/26 10:03
 * @Author: Mr.Zheng
 * @Description:
 */
public interface UserDao extends JpaRepository<UserEntity, Long>{
}
