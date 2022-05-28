package com.sport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sport.manager.BookingManager;

/**
 * Servlet implementation class DeleteTask
 */
@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get the task id from parameter
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		// call the deleteTask method in TaskManager and pass the id
		BookingManager bookingManager = new BookingManager();
		boolean status = bookingManager.deleteTask(booking_id);
		// redirect to ViewTasks servlet
		response.sendRedirect("ViewTasks");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
