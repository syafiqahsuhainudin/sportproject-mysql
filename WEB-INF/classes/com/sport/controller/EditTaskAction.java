package com.sport.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sport.manager.BookingManager;
import com.sport.model.EquipmentBean;
import com.sport.model.BookingBean;
import com.sport.model.UserBean;


/**
 * Servlet implementation class EditTaskAction
 */
@WebServlet("/EditTaskAction")
public class EditTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskAction() {
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
		
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		String date = request.getParameter("date");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String statusbook = request.getParameter("statusbook");
		// parse the due date to sql timestamp
		// date submitted by the form using 'datetime-local' type will be
		// in the following format: '1985-04-12T23:20:00'
		// make sure the seconds are set before parsing.
		// Chrome browser will ignore the seconds,
		// add seconds manually if not exist
		
		
		
		// prepare priorityBean using only id
		int equip_id = Integer.parseInt(request.getParameter("equipment"));
		EquipmentBean eb = new EquipmentBean();
		eb.setEquip_id(equip_id);
		
		
		// get UserBean from session. assume user already logged in
		HttpSession sess = request.getSession();
		UserBean ub = (UserBean) sess.getAttribute("userbean");
		
		
		// set everything into TaskBean
		BookingBean bb = new BookingBean();
		bb.setBooking_id(booking_id);
		bb.setQuantity(quantity);
		bb.setStatusbook(statusbook);
		bb.setDate(date);
		bb.setEquipmentBean(eb);
		bb.setUserBean(ub);
		
		
		// send this taskbean to editTask() in TaskManager to be updated
		BookingManager bookingManager = new BookingManager();
		boolean status = bookingManager.updateBooking(bb);
		
		
		// forward to Home page
		// we use response.sendRedirect since the ViewTasks is doGet()
		// and this is doPost()
		response.sendRedirect("ViewTasks");
	
	
	}

}
