package com.sport.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.manager.UserManager;
import com.sport.model.UserBean;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int userid =  0;
		String no_matric = request.getParameter("no_matric");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String no_phone = request.getParameter("no_phone");
		String password = request.getParameter("password");
		
		UserBean ub = new UserBean(userid,no_matric,fullname,email,no_phone,password);
		
		UserManager um = new UserManager();
		boolean status = false;
		try {
			
			status= um.register(ub);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("status", status);
		request.setAttribute("userbean", ub);
		request.setAttribute("mssg","Your Account Successfully save");
		request.getRequestDispatcher("userhome.jsp").forward(request,response);
		  
		 
		
	}

}
