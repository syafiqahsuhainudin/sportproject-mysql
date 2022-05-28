package com.sport.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sport.dao.EquipmentDA0;
import com.sport.model.EquipmentBean;




/**
 * Servlet implementation class EquipmentController
 */
@WebServlet("/EquipmentController")
public class EquipmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static String ADD = "equipmentform.jsp";
	    private static String UPDATE = "equipmentedit.jsp";
	    private static String DELETE = "staffequipment.jsp";
	   
	    private static String LIST_ALL = "staffequipment.jsp";
	    private static String LIST_ALLSTUD = "equipment.jsp";
	    private static String MSGREGISTER= "";
	    private EquipmentDA0 dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
        	EquipmentBean bean =new EquipmentBean();
    	    int equip_id = 	bean.setEquip_id(Integer.parseInt(request.getParameter("equip_id")));
    	    
    	    boolean sta = EquipmentDA0.delete(equip_id);
    	    forward = LIST_ALL;
    	    request.setAttribute("equipments", dao.getAllRecords());
			
	          
            
    } else if (action.equalsIgnoreCase("update")){
        	
        	      
        	    int equip_id = Integer.parseInt(request.getParameter("equip_id"));
	            request.setAttribute("equipment",dao.getRecordById(equip_id));
	            forward = UPDATE;
	            
	           
				
	            
        } else if (action.equalsIgnoreCase("listAll")){
        	forward = LIST_ALL;
        	forward = LIST_ALLSTUD;
        
        	request.setAttribute("equipments", dao.getAllRecords());
        }else {
            forward = ADD;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("update")) {
			
			EquipmentBean equipment = new EquipmentBean();
		
			equipment.setFilepath("C:\\image\\"+request.getParameter("filepath"));
			equipment.setEquip_name(request.getParameter("equip_name"));
			equipment.setEquip_quantity(Integer.parseInt(request.getParameter("equip_quantity")));
		
			

			String equip_id = request.getParameter("equip_id");
			
			
			if(equip_id == null || equip_id.isEmpty()){
		        dao.addequipment(equipment);
		        response.sendRedirect("staffequipment.jsp");
		    }
		    else{
		    	equipment.setEquip_id(Integer.parseInt(equip_id));
		         EquipmentDA0.updateequipment(equipment);
		     
		        response.sendRedirect("staffequipment.jsp");
		      
				request.setAttribute("mssg","Equipment succesfully save");
				RequestDispatcher view = request.getRequestDispatcher(MSGREGISTER);
				
		    }}
	}

}
