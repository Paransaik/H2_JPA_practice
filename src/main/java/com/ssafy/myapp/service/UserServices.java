package com.ssafy.myapp.service;

import com.ssafy.myapp.domain.User;

import java.util.Map;

public interface UserServices {
	int checkId(String id) throws Exception;

	void registUser(Map<String, String> map) throws Exception;

	void updateUser(Map<String, String> map) throws Exception;

	void deleteUser(String id) throws Exception;

	User infoUser(String id) throws Exception;

	User loginUser(String id, String password) throws Exception;

	int checkPasswordFind(String id, String email) throws Exception;

	void updatePassword(String id) throws Exception;

}
