package com.sport.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.manager.EquipmentManager;
import com.sport.manager.BookingManager;
import com.sport.model.EquipmentBean;
import com.sport.model.BookingBean;

/**
 * Servlet implementation class EditTask
 */
@WebServlet("/EditBookingStatus")
public class EditBookingStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookingStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get task id from GET parameter
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		
		// call the task manager to get the info of this task id
		BookingManager tm = new BookingManager();
		BookingBean  bookingBean = tm.getTask(booking_id);
		
		// get list of all priorities from database for the dropdown list
		EquipmentManager pm = new EquipmentManager();
		ArrayList<EquipmentBean> equipments = pm.getAllEquipment();
		
		// set the bean into request object
		request.setAttribute("bookingbean", bookingBean);
		request.setAttribute("equipments", equipments);
		
		// forward the request object to editTask.jsp
		request.getRequestDispatcher("statusupdate.jsp").forward(request, response);
		
	}



}
