package com.vastika.payroll.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vastika.payroll.basic.dao.UserDao;
import com.vastika.payroll.basic.dao.UserDaoImpl;
import com.vastika.payroll.basic.dao.service.UserService;
import com.vastika.payroll.basic.dao.service.UserServiceImpl;
import com.vastika.payroll.model.User;
import com.vastika.payroll.util.DbUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();
	
	public static final String USER_FORM = "userRegistration.jsp";
	public static final String USER_EDIT_FORM = "userEdit.jsp";
	public static final String USER_LIST = "userList.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";
		if(action.equals("add_user")) {
			forward = USER_FORM;
		}
		else if(action.equals("list_user")) {
			request.setAttribute("users", userService.getAllUserInfo());
			forward = USER_LIST;
		}
		else if(action.equals("delete_user")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userService.deleteUser(id);
			request.setAttribute("users", userService.getAllUserInfo());
			forward = USER_LIST;
		}
		else if(action.equals("edit_user")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", userService.getUserInfoById(id));
			forward = USER_EDIT_FORM;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user =  new User();
		user.setUsername( request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dob = sdf.parse(request.getParameter("dob"));
			user.setDob(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setNationality(request.getParameter("nationality"));
		
		String [] hobby = request.getParameterValues("hobbies");
		String hobbies = "";
		for(String hob: hobby) {
			hobbies = hobbies + hob + ",";
		}
		
		user.setHobbies(hobbies);
		String userId = request.getParameter("id");
		
		
		userService.saveUserInfo(user);
		if(userId==null || userId.isEmpty()) {
			userService.saveUserInfo(user);
		}else {
			user.setId(Integer.parseInt(userId));
			userService.updateUserInfo(user);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		request.setAttribute("users", userService.getAllUserInfo());
		rd.forward(request, response);



	}

}
