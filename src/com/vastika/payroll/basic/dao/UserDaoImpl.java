package com.vastika.payroll.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.payroll.model.User;
import com.vastika.payroll.util.DbUtil;

public class UserDaoImpl implements UserDao {

	public static final String INSERT_SQL = "Insert into user_tbl(user_name, password, email, gender, dob, hobbies, nationality) values(?,?,?,?,?,?,?)";
	public static final String SELECT_SQL = "select * from user_tbl";
	public static final String DELETE_SQL = "delete from user_tbl where id = ?";
	public static final String SELECT_SQL_BY_ID = "select * from user_tbl where id = ?";
	public static final String UPDATE_SQL = "update user_tbl set user_name=?, password=?, email=?, gender=?, dob=?, hobbies=?, nationality=? where id = ?";

	
	@Override
	public void saveUserInfo(User user) {
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_SQL);) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setDate(5, new java.sql.Date(user.getDob().getTime()));
			ps.setString(6, user.getHobbies());
			ps.setString(7, user.getNationality());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_SQL);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setHobbies(rs.getString("hobbies"));
				user.setNationality(rs.getString("nationality"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void deleteUser(int id) {
		try (Connection con = DbUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQL);) {
			ps.setInt(1, id);
			ps.executeUpdate();
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}

	@Override
	public void updateUserInfo(User user) {
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_SQL);) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setDate(5, new java.sql.Date(user.getDob().getTime()));
			ps.setString(6, user.getHobbies());
			ps.setString(7, user.getNationality());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserInfoById(int id) {
		User user = new User();
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_SQL_BY_ID);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setHobbies(rs.getString("hobbies"));
				user.setNationality(rs.getString("nationality"));
				user.setDob(rs.getDate("dob"));
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
