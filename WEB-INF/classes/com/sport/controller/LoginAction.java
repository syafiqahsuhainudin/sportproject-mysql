package com.sport.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sport.manager.UserManager;
import com.sport.model.UserBean;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
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
		String no_matric=request.getParameter("no_matric");
		String password=request.getParameter("password");
		
		UserManager um=new UserManager();
		UserBean ub=null;
		try {
			ub=um.login(no_matric, password);
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		if(ub==null) {
			request.setAttribute("fail",true);
			request.getRequestDispatcher("userhome.jsp").forward(request,response);
			
		}
		else {
			HttpSession session=request.getSession(true);
			session.setAttribute("account", ub);
			session.setAttribute("sessionId", ub.getUserid());
		
			request.getRequestDispatcher("Home")
			.forward(request,response);
		}
	}

}
