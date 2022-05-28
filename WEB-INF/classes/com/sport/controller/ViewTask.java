package com.sport.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sport.manager.BookingManager;
import com.sport.model.BookingBean;
import com.sport.model.UserBean;


/**
 * Servlet implementation class ViewTask
 */
@WebServlet("/ViewTasks")
public class ViewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// fetch all tasks from database for this user
		
		// assume user already logged in
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)session.getAttribute("account");
	
		
		// fetch all task using TaskManager
		
		
		// fetch all task using TaskManager
		BookingManager tm = new 	BookingManager();
		ArrayList<BookingBean> books = tm.fetchAllTasks(userBean);
		
		// set to request scope and forward to JSP
		request.setAttribute("books", books);
		request.getRequestDispatcher("booking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
