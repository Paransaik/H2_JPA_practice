package com.ssafy.myapp.model.dao;

import com.ssafy.myapp.domain.User;
//import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

//@Mapper
public interface UserDAO {
    int checkId(String id) throws Exception;

    void registUser(Map<String, String> map) throws Exception;

    void updateUser(Map<String, String> map) throws Exception;

    void deleteUser(String id) throws Exception;

    User infoUser(String id) throws Exception;

    User loginUser(String id, String password) throws Exception;

    int checkPasswordFind(Map<String, String> map) throws Exception;

    void updatePassword(Map<String, String> map) throws Exception;

}