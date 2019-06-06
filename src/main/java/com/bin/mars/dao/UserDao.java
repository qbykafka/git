package com.bin.mars.dao;

import com.bin.mars.entity.TsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<TsUser,Long> {

}
