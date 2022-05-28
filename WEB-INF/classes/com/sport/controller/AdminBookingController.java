package com.sport.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.dao.AccountDAO;
import com.sport.manager.BookingManager;

/**
 * Servlet implementation class AdminBookingController
 */
@WebServlet("/AdminBookingController")
public class AdminBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static String ADD = "/..";
	    private static String UPDATE = "";
	    private static String DELETE = "";
	    private static String LIST_ALL = "staffbooking.jsp";
	    private static String MSGREGISTER= "";
	    private BookingManager dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookingController() {
        super();
        dao = new BookingManager();
    }
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	        	    int booking_id = Integer.parseInt(request.getParameter("booking_id"));
	        	   
		            forward = LIST_ALL;
		            request.setAttribute("bookings", dao.getAllBooking());  
		            
	        } else if (action.equalsIgnoreCase("update")){
	        	
	        	      
	        	  int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		           // request.setAttribute("bookings",dao.getRecordById(booking_id));
		            forward = UPDATE;
		          
					
		            
	        } else if (action.equalsIgnoreCase("listAll")){
	        	forward = LIST_ALL;
	        	request.setAttribute("bookings", dao.getAllBooking());
	        }else {
	            forward = ADD;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
		
	        // TODO Auto-generated constructor stub
	    
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
