package com.sport.controller;

import java.text.ParseException;  

import java.util.Date;  
import java.util.Locale;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.dao.AccountDAO;
import com.sport.dao.AccountStaffDAO;
import com.sport.model.StaffBean;

import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AccountStaffController")

public class AccountStaffController extends HttpServlet {
	 /**
     * @see HttpServlet#HttpServlet()
     */
	private static final long serialVersionUID = 1L;
	private static final String MSGREGISTER = null;
	 private static String ADD = "/..";
	    private static String UPDATE = "updateStaffAccount.jsp";
	    private static String DELETE = "student.jsp";
	    private static String LIST_ALL = "student.jsp";
	    private AccountStaffDAO dao;
    
    public AccountStaffController() {
        super();
        dao = new AccountStaffDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
        	 Integer id = Integer.parseInt(request.getParameter("id"));
        	    dao.deleteAccount(id);
	            forward = LIST_ALL;
	            request.setAttribute("staffacc", dao.getAllRecords());  
	            
        } else if (action.equalsIgnoreCase("update")){
        	    forward = UPDATE;
        	      
        	    Integer id = Integer.parseInt(request.getParameter("id"));
	            StaffBean staffbean = dao.getRecordById(id);
	            request.setAttribute("staffacc", staffbean);
	            
        } else if (action.equalsIgnoreCase("listAll")){
        	forward = LIST_ALL;
        	request.setAttribute("staffaccs", dao.getAllRecords());
        }else {
            forward = ADD;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("update")) {
		StaffBean staffacc = new StaffBean();
		staffacc.setStaff_id(request.getParameter("staff_id"));
		staffacc.setStaff_name(request.getParameter("staff_name"));
		staffacc.setStaff_phone(request.getParameter("staff_phone"));
		staffacc.setStaff_email(request.getParameter("staff_email"));
		staffacc.setStaff_password(request.getParameter("staff_password"));
		

		 Integer id = Integer.parseInt(request.getParameter("id"));
		
		 staffacc.setId(id);
	         AccountStaffDAO.update(staffacc);
	   
	        response.sendRedirect("accountStaff.jsp");
	        request.setAttribute("mssg","Your Account Successfully Updated");
			RequestDispatcher view = request.getRequestDispatcher(MSGREGISTER);
	}}}



