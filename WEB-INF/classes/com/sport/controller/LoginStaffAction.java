package com.sport.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sport.model.StaffBean;
import com.sport.manager.StaffManager;

/**
 * Servlet implementation class LoginStaffAction
 */
@WebServlet("/LoginStaffAction")
public class LoginStaffAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStaffAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameters
		String staff_id=request.getParameter("staff_id");
		String staff_password=request.getParameter("staff_password");
		
		//create StaffManager object
		StaffManager ssm=new StaffManager();
		StaffBean staffb=null;
		try {
			staffb=ssm.login(staff_id, staff_password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(staffb==null) {
			//login failed
			//forward back to login page and send a
			//parameter fail
			request.setAttribute("fail",true);
			request.getRequestDispatcher("loginStaff.jsp").forward(request,response);
		}
		
		else {
			//login success,set session
			HttpSession s=request.getSession();
			s.setAttribute("sessionId", staffb.getId());
			s.setAttribute("staffacc",staffb);
			//and forward to Home Servlet
			request.getRequestDispatcher("StaffHome").forward(request, response);
		}
	}

}
