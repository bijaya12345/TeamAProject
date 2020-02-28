package com.vastika.payroll.basic.dao.service;

import java.util.List;

import com.vastika.payroll.model.User;

public interface UserService {
	
	void saveUserInfo(User user);
	List<User> getAllUserInfo();
	void deleteUser(int id);
	void updateUserInfo(User user );
	User getUserInfoById(int id);
}
