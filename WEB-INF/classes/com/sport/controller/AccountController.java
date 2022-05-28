package com.sport.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.dao.AccountDAO;
import com.sport.model.UserBean;

@WebServlet("/AccountController")

public class AccountController extends HttpServlet {
	 /**
     * @see HttpServlet#HttpServlet()
     */
	private static final long serialVersionUID = 1L;
	 private static String ADD = "/..";
	    private static String UPDATE = "updateaccount.jsp";
	    private static String DELETE = "student.jsp";
	    private static String LIST_ALL = "student.jsp";
	    private static String MSGREGISTER= "";
	    private AccountDAO dao;
    
    public AccountController() {
        super();
        dao = new AccountDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
        	    int userid = Integer.parseInt(request.getParameter("userid"));
        	    dao.deleteAccount(userid);
	            forward = LIST_ALL;
	            request.setAttribute("accounts", dao.getAllRecords());  
	            
        } else if (action.equalsIgnoreCase("update")){
        	
        	      
        	    int userid = Integer.parseInt(request.getParameter("userid"));
	            request.setAttribute("account",dao.getRecordById(userid));
	            forward = UPDATE;
	          
				
	            
        } else if (action.equalsIgnoreCase("listAll")){
        	forward = LIST_ALL;
        	request.setAttribute("accounts", dao.getAllRecords());
        }else {
            forward = ADD;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("update")) {
		UserBean account = new UserBean();
		account.setNo_matric(request.getParameter("no_matric"));
		account.setFullname(request.getParameter("fullname"));
		account.setEmail(request.getParameter("email"));
		account.setNo_phone(request.getParameter("no_phone"));
		account.setPassword(request.getParameter("password"));
		

		String userid = request.getParameter("userid");
		if(userid == null || userid.isEmpty()){
	        dao.save(account);
	    }
	    else{
	         account.setUserid(Integer.parseInt(userid));
	         AccountDAO.update(account);
	   
	        response.sendRedirect("account.jsp");
	        request.setAttribute("mssg","Your Account Successfully Updated");
			RequestDispatcher view = request.getRequestDispatcher(MSGREGISTER);
			
			
	}}}}



