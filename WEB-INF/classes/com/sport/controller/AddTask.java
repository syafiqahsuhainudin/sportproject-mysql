package com.sport.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.manager.EquipmentManager;
import com.sport.model.EquipmentBean;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EquipmentManager pm = new EquipmentManager();
		ArrayList<EquipmentBean> equipments = pm.getAllEquipment();
		// set to request scope
		request.setAttribute("equipments", equipments);
		// forward to addTask.jsp
		request.getRequestDispatcher("bookingform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
