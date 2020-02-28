package com.vastika.payroll.basic.dao;



import java.util.List;

import com.vastika.payroll.model.User;


public interface UserDao {
	
	void saveUserInfo(User user);
	
	List<User> getAllUserInfo();
	//what's up!!
	
	void deleteUser(int id);
	
	void updateUserInfo(User id);
	
	User getUserInfoById(int id);
}
