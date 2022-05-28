package com.sport.controller;

import java.io.IOException;
import java.util.Date;
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
import java.util.*;
/**
 * Servlet implementation class AddTaskAction
 */
@WebServlet("/AddTaskAction")
public class AddTaskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskAction() {
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
			
		// get values from the form
		// parameter names depends on your field names
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		
		String date = request.getParameter("date");
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
		UserBean ub = (UserBean)sess.getAttribute("account");
		
		// set everything into TaskBean
		BookingBean bb = new BookingBean();
		bb.setQuantity(quantity);
		bb.setStatusbook(statusbook);
		bb.setDate(date);
		bb.setEquipmentBean(eb);
		bb.setUserBean(ub);
		
		// send this taskbean to addTask() in TaskManager to be inserted to database
		BookingManager bookingManager = new BookingManager();
		boolean status = bookingManager.addTask(bb);
		
		// forward to jsp
		request.setAttribute("status", status);
		request.setAttribute("bookingbean", bb);
		request.getRequestDispatcher("addBookingStatus.jsp").forward(request, response);
	}

}
